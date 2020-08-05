package lt.rest.leasing.repo;

import lt.rest.leasing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<User,Long> {
}
