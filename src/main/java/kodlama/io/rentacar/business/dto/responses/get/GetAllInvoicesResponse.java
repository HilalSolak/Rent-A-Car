package kodlama.io.rentacar.business.dto.responses.get;

import java.time.LocalDateTime;

public class GetAllInvoicesResponse {
    private int id;
    private String cardHolder;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private int rentedForDays;

    private double totalPrice;
    private LocalDateTime rentedAt;
}
