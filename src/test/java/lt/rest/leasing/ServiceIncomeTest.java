package lt.rest.leasing;

import lt.rest.leasing.dto.ApplyDto;
import lt.rest.leasing.dto.PersonDto;
import lt.rest.leasing.dto.VehicleDto;
import lt.rest.leasing.rest.ControllerV1;
import lt.rest.leasing.service.ApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ServiceIncomeTest {

    @Autowired
    ControllerV1 controller;
    @Autowired
    ApplyService service;

    @Value("${income.requirements}")
    private int REQUIREMENTS;

    @Test
    void checkIfAnswerTrueIfIncomeOk(){
        List<PersonDto> list=new ArrayList<>();
        PersonDto person=new PersonDto();
        person.setName("Donald");
        person.setSurname("Trump");
        person.setEmail("Some@mail.com");
        person.setIncome(BigDecimal.valueOf(REQUIREMENTS-1));
        list.add(person);

        VehicleDto vehicle=new VehicleDto();
        vehicle.setCost(BigDecimal.valueOf(100000));
        vehicle.setEngine(2.0);
        vehicle.setCarName("Dodge firefly");

        ApplyDto apply=new ApplyDto();
        apply.setRequestedMoney(BigDecimal.valueOf(120000));
        apply.setFamily(list);
        apply.setVehicleDto(vehicle);

        controller.addLeasingApply(apply);
        boolean answer = service.checkLeasingResultById(1L);

        assertFalse(answer, "Should return false");
    }
}
