package nomaralessNomadEmployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeServiceImp serviceImp;

    public EmployeeController(EmployeeServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @RequestMapping
    public String employee() {
        return serviceImp.employee();
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName,
                        @RequestParam(value = "department", required = false) int department,
                        @RequestParam(value = "salary", required = false) double salary) {
        return serviceImp.add(firstName, lastName, department, salary);

    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstNAme", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName,
                           @RequestParam(value = "department", required = false) int department,
                           @RequestParam(value = "salary", required = false) double salary) {
        return serviceImp.remove(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return serviceImp.find(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public String all() {
        return serviceImp.allEmployee().toString();
    }
}
