package lt.rest.leasing.repo;

import lt.rest.leasing.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoPerson extends JpaRepository<Person,Long> {
}
