package kodlama.io.rentacar.core.utils.results;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResult<T> {
    private LocalDateTime timestamp;
    private String type;
    private T message;


    public ExceptionResult(String type, T message) {
        timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }

   /*  public ExceptionResult(Class<T> type, String message) {
        this.type = convertToUpperCaseWithUnderscores(type.getSimpleName());
        this.message = message;
    }

    private String convertToUpperCaseWithUnderscores(String camelCaseString) {
        return camelCaseString.replaceAll("(.)(\\p{Upper})", "$1_$2".toUpperCase());
    }*/
}
