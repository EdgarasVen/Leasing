package lt.rest.leasing.dto;

import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.User;
import lt.rest.leasing.model.Vehicle;

import java.math.BigDecimal;

public class ApplyDto {

    private String name;
    private String surname;
    private String email;
    private BigDecimal income;

    private String carName;
    private double engine;
    private BigDecimal cost;

    private BigDecimal requestedMoney;

    public User toUser(){
        User user=new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setIncome(income);
        return user;
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
