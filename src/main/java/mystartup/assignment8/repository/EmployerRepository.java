package mystartup.assignment8.repository;

import mystartup.assignment8.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Employer getById(long id);
}
