package nomaralessNomadEmployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping
    public String employee() {
        return employeeService.employee();
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam(value = "firstName", required = false) String firstName,
                      @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.add(firstName, lastName);

    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam(value = "firstNAme", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam(value = "firstName", required = false) String firstName,
                       @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public String all() {
        return employeeService.allemployee();
    }
}
