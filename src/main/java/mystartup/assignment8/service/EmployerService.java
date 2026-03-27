package mystartup.assignment8.service;

import lombok.RequiredArgsConstructor;
import mystartup.assignment8.dto.CreateEmployer;
import mystartup.assignment8.dto.UpdateEmployer;
import mystartup.assignment8.models.Employer;
import mystartup.assignment8.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer createEmployer(CreateEmployer employer) {
        Employer employer1 = new Employer();
        employer1.setName(employer.name());
        employer1.setPosition(employer.position());
        employer1.setSalary(employer.salary());
        employer1.setHireDate(employer.hireDate());
        return employerRepository.save(employer1);
    }
    public Employer getEmployerById(Long id) {
        return employerRepository.getById(id);
    }
    public Employer updateEmployer(Long id,UpdateEmployer employer) {
        Employer employer1 = employerRepository.getById(id);
        employer1.setName(employer.name());
        employer1.setPosition(employer.position());
        employer1.setSalary(employer.salary());
        employer1.setHireDate(employer.hireDate());
        return employerRepository.save(employer1);
    }
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }

}
