package lt.rest.leasing.dto;

import lombok.Getter;
import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ApplyDto {

    private List<PersonDto> family;

    private String carName;
    private double engine;
    private BigDecimal cost;

    private BigDecimal requestedMoney;

    public List<Person> toPersonList(){
        List<Person> personList=new ArrayList<>();
        for (PersonDto personDto: family
             ) {
            Person person =new Person();
            person.setName(personDto.getName());
            person.setSurname(personDto.getSurname());
            person.setEmail(personDto.getEmail());
            person.setIncome(personDto.getIncome());
            personList.add(person);
        }
        return personList;
    }

    public Vehicle toVehicle(){
        Vehicle vehicle=new Vehicle();
        vehicle.setCarName(carName);
        vehicle.setEngine(engine);
        vehicle.setCost(cost);
        return vehicle;
    }

    public LeasingApply toLeasingApply(){
        LeasingApply leasingApply=new LeasingApply();
        leasingApply.setRequestedMoney(requestedMoney);
        return leasingApply;
    }
}
