package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.CarMaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.post.FilterCarMaintenancePost;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carmaintenances")
@AllArgsConstructor
public class CarMaintenancesController {
    private final CarMaintenanceService services;

    @GetMapping("/getAll")
    public List<GetAllCarMaintenanceResponse> findAll(FilterCarMaintenancePost post){
        return services.getAll(post);
    }

    @GetMapping("/getId/{id}")
    public GetCarMaintenanceResponse getById(@PathVariable int id) {
        return services.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarMaintenanceResponse add(@RequestBody CreateCarMaintenanceRequest request) {
        return services.add(request);
    }

    @PutMapping("/update/{id}")
    public UpdateCarMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateCarMaintenanceRequest request) {
        return services.update(id, request);
    }
}
