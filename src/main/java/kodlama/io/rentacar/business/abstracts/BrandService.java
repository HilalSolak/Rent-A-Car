package kodlama.io.rentacar.business.abstracts;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();//getAll'ın içinde brand yok o yüzden requesst olmayacak response olacak
    GetBrandResponse getById(int id);//getById'nin içinde brand yok o yüzden requesst olmayacak response olacak
    CreateBrandResponse add(CreateBrandRequest request);//hem respond hem request
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);
}
