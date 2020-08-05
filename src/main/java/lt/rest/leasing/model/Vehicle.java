package lt.rest.leasing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle extends BaseEntity{

    private String carName;
    private double engine;
    private BigDecimal cost;

    @OneToOne(mappedBy = "vehicle")
    @JsonIgnore
    private LeasingApply leasingApply;
}
