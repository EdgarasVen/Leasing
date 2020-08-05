package lt.rest.leasing.repo;

import lt.rest.leasing.model.LeasingApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLeasingApply extends JpaRepository<LeasingApply,Long> {
}
