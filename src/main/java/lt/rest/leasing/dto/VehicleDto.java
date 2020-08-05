package lt.rest.leasing.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicleDto {
    private String carName;
    private double engine;
    private BigDecimal cost;

}
