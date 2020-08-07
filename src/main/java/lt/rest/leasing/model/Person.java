package lt.rest.leasing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person extends BaseEntity{

    private String name;
    private String surname;
    private String email;
    private BigDecimal income;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private LeasingApply leasingApply;

}
