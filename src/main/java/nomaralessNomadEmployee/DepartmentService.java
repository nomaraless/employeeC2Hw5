package nomaralessNomadEmployee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllByDepartment(int department);

    public Map<Integer, List<Employee>> getAll();

    Employee maxSalary(int department);

    Employee minSalary(int department);

    double sumSalary(int department);
}
