package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();//getAll'ın içinde brand yok o yüzden requesst olmayacak response olacak
    GetCarResponse getById(int id);//getById'nin içinde brand yok o yüzden requesst olmayacak response olacak
    CreateCarResponse add(CreateCarRequest request);//hem respond hem request
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void delete(int id);
}
