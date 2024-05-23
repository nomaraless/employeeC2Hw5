package nomaralessNomadEmployee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of());
    private final int SIZE = 10;

    public String employee() {
        return "Добро пожаловать в книгу учета сотрудников";
    }
    public String add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee.toString();
    }

    public String remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee.toString();
    }

    public String find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            return employee.toString();
        }
    }

    public String allemployee() {
            return employees.toString();
    }
}
