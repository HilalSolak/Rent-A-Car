package kodlama.io.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPaymentsResponse {
    private int id;
    private String cardNumber;
    private String cardHolder;
    private int carExpirationYear;
    private int cardExpirationMonth;
    private String cardCvv;
    private double balence;
}
