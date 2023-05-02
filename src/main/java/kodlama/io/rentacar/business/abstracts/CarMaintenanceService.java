package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.post.FilterCarMaintenancePost;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarMaintenanceResponse;

import java.util.List;

public interface CarMaintenanceService {
    List<GetAllCarMaintenanceResponse> getAll(FilterCarMaintenancePost post);
    GetCarMaintenanceResponse getById(int id);
    CreateCarMaintenanceResponse add(CreateCarMaintenanceRequest request);
    UpdateCarMaintenanceResponse update(int id, UpdateCarMaintenanceRequest request);



}
