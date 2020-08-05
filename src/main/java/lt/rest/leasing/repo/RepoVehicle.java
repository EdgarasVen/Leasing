package lt.rest.leasing.repo;

import lt.rest.leasing.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoVehicle extends JpaRepository<Vehicle,Long> {
}
