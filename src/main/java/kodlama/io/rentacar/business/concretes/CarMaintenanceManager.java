package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarMaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.post.FilterCarMaintenancePost;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarMaintenanceResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.CarMaintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.CarMaintenancesRepository;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarMaintenanceManager implements CarMaintenanceService {
    private final CarRepository carRepository;
    private final CarMaintenancesRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCarMaintenanceResponse> getAll(FilterCarMaintenancePost post) {
        if(post.isFilter()) {
            List<Car> cars = carRepository.findAll();
            List<GetAllCarMaintenanceResponse> response = cars
                    .stream().filter((car) -> !car.getState().equals(State.MAINTANCE))
                    .map(car -> mapper.map(car, GetAllCarMaintenanceResponse.class))
                    .toList();
            checkIfGetAllSize(response.size());
            return response;
        }else {
            List<Car> cars = carRepository.findAll();
            List<GetAllCarMaintenanceResponse> response = cars
                    .stream()
                    .map(car -> mapper.map(car, GetAllCarMaintenanceResponse.class))
                    .toList();
            checkIfGetAllSize(response.size());
            return response;
        }
    }

    @Override
    public GetCarMaintenanceResponse getById(int id) {
        checkIfMaintenanceExits(id);
        CarMaintenance maintenance = repository.findById(id).orElseThrow();
        GetCarMaintenanceResponse response = mapper.map(maintenance,GetCarMaintenanceResponse.class);
        return response;
    }

    @Override
    public CreateCarMaintenanceResponse add(CreateCarMaintenanceRequest request) {
        checkIfCreateMaintenance(request.getCarId());
        CarMaintenance maintenance = mapper.map(request,CarMaintenance.class);
        maintenance.setId(0);
        repository.save(maintenance);
        CreateCarMaintenanceResponse response = mapper.map(maintenance,CreateCarMaintenanceResponse.class);
        Car car = carRepository.findById(request.getCarId()).orElseThrow();
        car.setState(State.MAINTANCE);
        carRepository.save(car);
        return response;
    }

    @Override
    public UpdateCarMaintenanceResponse update(int id, UpdateCarMaintenanceRequest request) {
        CarMaintenance maintenance = mapper.map(request,CarMaintenance.class);
        CarMaintenance maintenance1 = repository.findById(id).orElseThrow();
        maintenance.setId(id);
        maintenance.setLocalTime(maintenance1.getLocalTime());
        repository.save(maintenance);
        UpdateCarMaintenanceResponse response = mapper.map(maintenance,UpdateCarMaintenanceResponse.class);
        Car car = carRepository.findById(request.getCarId()).orElseThrow();
        car.setState(State.AVAILABLE);
        carRepository.save(car);

        return response;
    }





    private void checkIfMaintenanceExits(int id){
        if(!repository.existsById(id))
            throw new RuntimeException("Araba mevcut değil");
    }
    private void checkIfGetAllSize(int size){
        if (size==0)throw new RuntimeException("Araba bulunmamaktadır.");
    }
    private void checkIfCreateMaintenance(int id){
        Car car = carRepository.findById(id).orElseThrow();
        if (car.getState().equals(State.MAINTANCE)){
            throw  new RuntimeException("Bakımdaki aracı tekrardan bakıma gönderemezsiniz.");
        } else if (car.getState().equals(State.RENTED)) {
            throw  new RuntimeException("Kiralamadaki araç bakıma gönderilemez");
        }
    }
    private void checkIfCarState(State state,State state2) {
        if (state.equals(State.MAINTANCE) && state2.equals(State.MAINTANCE))
            throw new RuntimeException("Bakımdaki ürün bakıma gönderilemez");
        else if (state.equals(State.RENTED) && state2.equals(State.MAINTANCE))
            throw new RuntimeException("Kirada olan araba bakıma gidemez.");
    }
}
