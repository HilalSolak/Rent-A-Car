package kodlama.io.rentacar.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Bu clasa @Entitiy koymadık çünkü veritabanına karşılık gelen bir tablo değil burası
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandRequest {
    private String name;
}
