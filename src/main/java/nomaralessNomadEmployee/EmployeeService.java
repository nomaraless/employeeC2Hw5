package nomaralessNomadEmployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final HashMap<String, Employee> employees = new HashMap(Map.of());
    private final int SIZE = 10;

    public String employee() {
        return "Добро пожаловать в книгу учета сотрудников";
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = firstName + " " + lastName;
        if (employees.size() >= SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employeeKey, employee);
        return employees.get(employeeKey);
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = firstName + " " + lastName;
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employeeKey);
        return employees.get(employeeKey);
    }

    public Employee find(String firstName, String lastName) {
        String employeeKey = firstName + " " + lastName;
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.get(employeeKey);
        }
    }

    public String allEmployee() {
        return employees.values().toString();
    }
}
