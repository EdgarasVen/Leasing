package lt.rest.leasing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity{

    private String name;
    private String surname;
    private String email;
    private BigDecimal income;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LeasingApply> leasingApply;

}
