package lt.rest.leasing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
