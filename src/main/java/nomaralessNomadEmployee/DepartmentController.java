package nomaralessNomadEmployee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllByDepartment(@RequestParam(required = false) Integer department) {
        return department == null ?
                ResponseEntity.ok(service.getAll()) :
                ResponseEntity.ok(service.getAllByDepartment(department));
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer department) {
        return service.maxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer department) {
        return service.minSalary(department);
    }
}
