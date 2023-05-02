package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.CarMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMaintenancesRepository extends JpaRepository<CarMaintenance,Integer> {

}
