package lt.rest.leasing.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

/**
 * Exception class for search if object not find
 * @author  Edgaras Venzlauskas
 * @version 1.0
 *
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFindException extends RuntimeException  {

    public ResourceNotFindException(String message){
        super(message);
    }
}
