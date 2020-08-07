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
public class LeasingApply extends BaseEntity{

    private BigDecimal requestedMoney;
    private boolean answer;

    @OneToMany(mappedBy = "leasingApply", cascade = CascadeType.ALL)
    private List<Person> family;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leasing_id", referencedColumnName = "id")
    private Vehicle vehicle;

}
