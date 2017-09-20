package employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
    public Employee get(@PathVariable String employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String message() {
        return "Welcome to this wonderful application !";
    }

}
