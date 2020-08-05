package lt.rest.leasing.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PersonDto {

    private String name;
    private String surname;
    private String email;
    private BigDecimal income;
}
