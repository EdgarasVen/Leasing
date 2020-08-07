package lt.rest.leasing.service;

import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;

import java.util.List;

public interface ApplyService {

    void addListOfPersons(List<Person> personList);
    void addVehicle(Vehicle vehicle);
    boolean addLeasingApply(LeasingApply leasingApply);

    boolean checkLeasingResultById(Long id);
}
