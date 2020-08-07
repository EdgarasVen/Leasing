package lt.rest.leasing;

import lt.rest.leasing.dto.ApplyDto;
import lt.rest.leasing.dto.PersonDto;
import lt.rest.leasing.dto.VehicleDto;
import lt.rest.leasing.rest.ControllerV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LeasingApplication implements CommandLineRunner {
	@Autowired
	ControllerV1 controllerV1;

	public static void main(String[] args) {
		SpringApplication.run(LeasingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<PersonDto> list=new ArrayList<>();
		PersonDto person=new PersonDto();
		person.setName("Donald");
		person.setSurname("Trump");
		person.setEmail("Some@mail.com");
		person.setIncome(BigDecimal.valueOf(500));
		list.add(person);

		VehicleDto vehicle=new VehicleDto();
		vehicle.setCost(BigDecimal.valueOf(100000));
		vehicle.setEngine(2.0);
		vehicle.setCarName("Dodge firefly");

		ApplyDto apply=new ApplyDto();
		apply.setFamily(list);
		apply.setVehicleDto(vehicle);

		controllerV1.addLeasingApply(apply);

	}
}
