package kodlama.io.rentacar.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarMaintenanceResponse {
    private int id;
    private int carId;
    private Date localTime;
    private Date exitTime;
    private String description;
}
