package kodlama.io.rentacar.business.abstracts;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();//getAll'ın içinde brand yok o yüzden requesst olmayacak response olacak
    GetModelResponse getById(int id);//getById'nin içinde brand yok o yüzden requesst olmayacak response olacak
    CreateModelResponse add(CreateModelRequest request);//hem respond hem request
    UpdateModelResponse update(int id, UpdateModelRequest request);
    void delete(int id);
}
