package nomaralessNomadEmployee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    final HashMap<String, Employee> employees = new HashMap<>(Map.of());
    final int SIZE = 5;

    @Override
    public String employee() {
        return "Добро пожаловать в книгу учета сотрудников";
    }

    @Override
    public Employee add(String firstName, String lastName, int departament, double salary) {
        Employee employee = new Employee(firstName, lastName, departament, salary);
        String employeeKey = firstName + " " + lastName;
        if (employees.size() >= SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException();
        }
        checkInput(firstName,lastName);
        employees.put(employeeKey, employee);
        return employees.get(employeeKey);
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String employeeKey = firstName + " " + lastName;
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employeeKey);
        return employees.get(employeeKey);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String employeeKey = firstName + " " + lastName;
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.get(employeeKey);
        }
    }

    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void checkInput(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new BadRequestException();
        }
    }
}
