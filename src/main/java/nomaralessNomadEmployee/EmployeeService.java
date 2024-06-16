package nomaralessNomadEmployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface EmployeeService {
    String employee();

    Employee add(String firstName, String lastName, int departament, double salary);

    Employee remove(String firstName, String lastName, int department, double salary);

    Employee find(String firstName, String lastName);

    Collection<Employee> allEmployee();
}
