package nomaralessNomadEmployee;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private EmployeeServiceImp serviceImp;

    public DepartmentServiceImp(EmployeeServiceImp serviceImp) {

    }

    @Override
    public List<Employee> getAllByDepartment(int department) {
        return serviceImp.allEmployee().stream().filter(employee -> employee.getDepartament()==department).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAll() {
        return serviceImp.allEmployee().stream().collect(Collectors.groupingBy(Employee::getDepartament));
    }

    @Override
    public Employee maxSalary(int department) {
        return serviceImp.allEmployee().stream().filter(employee ->
                employee.getDepartament()==department).max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalary(int department) {
        return serviceImp.allEmployee().stream().filter(employee ->
                employee.getDepartament()==department).min(Comparator.comparingDouble(Employee::getSalary)).orElseThrow(EmployeeNotFoundException::new);
    }
}
