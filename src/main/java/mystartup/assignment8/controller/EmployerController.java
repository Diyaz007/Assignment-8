package mystartup.assignment8.controller;

import lombok.RequiredArgsConstructor;
import mystartup.assignment8.dto.CreateEmployer;
import mystartup.assignment8.dto.UpdateEmployer;
import mystartup.assignment8.models.Employer;
import mystartup.assignment8.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")

public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employer createEmployer(@RequestBody CreateEmployer createEmployer) {
        return employerService.createEmployer(createEmployer);
    }

    @GetMapping("/{id}")
    public Employer getEmployerById(@PathVariable Long id) {
        return employerService.getEmployerById(id);
    }

    @PutMapping("/{id}")
    public Employer updateEmployer(@PathVariable Long id, @RequestBody UpdateEmployer updateEmployer) {
        return employerService.updateEmployer(id,updateEmployer);
    }

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
    }
}