package lt.rest.leasing.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PersonDto {

    private String name;
    private String surname;
    private String email;
    private BigDecimal income;
}
