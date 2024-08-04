package nomaralessNomadEmployee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nomaralessNomadEmployee.SourceForTest.*;
import static org.junit.jupiter.api.Assertions.*;
import  nomaralessNomadEmployee.EmployeeAlreadyAddedException.*;
import  nomaralessNomadEmployee.BadRequestException.*;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class EmployeeServiceImpTest {
    EmployeeServiceImp serviceImp;

    @BeforeEach
    public void setUp() {
        serviceImp = new EmployeeServiceImp();
    }

        @Test
        public void addTest() {
            Employee actual = serviceImp.add(F_NAME2, L_NAME1, DEPARTMENT1, SALARY1);
            Employee expected = new Employee(F_NAME2, L_NAME1, DEPARTMENT1, SALARY1);
            assertEquals(actual, expected);
        }

    @Test
    public void addEmployeeAlreadyTest() throws BadRequestException {
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            Employee e1 = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
            // Попытка добавить того же сотрудника, что должно вызвать исключение
            Employee e2 = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
        });
    }

    @Test
    public void addEmployeeBadRequestFName() throws BadRequestException {
        assertThrows(BadRequestException.class, () -> {
            Employee e1 = serviceImp.add("null1", L_NAME1, DEPARTMENT1, SALARY1);
        });
    }

    @Test
    public void addEmployeeBadRequestLName() throws BadRequestException {
        assertThrows(BadRequestException.class, () -> {
            Employee e1 = serviceImp.add(F_NAME1, "p+p", DEPARTMENT1, SALARY1);
        });
    }

    @Test
    public void addEmployeeStorageIsFullException() throws BadRequestException {
        assertThrows(EmployeeStorageIsFullException.class, () -> {
            Employee e1 = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
            Employee e2 = serviceImp.add(F_NAME2, L_NAME2, DEPARTMENT1, SALARY1);
            Employee e3 = serviceImp.add(F_NAME3, L_NAME3, DEPARTMENT1, SALARY1);
            Employee e4 = serviceImp.add(F_NAME4, L_NAME4, DEPARTMENT1, SALARY1);
            Employee e5 = serviceImp.add(F_NAME5, L_NAME5, DEPARTMENT1, SALARY1);
            Employee e6 = serviceImp.add(F_NAME1, L_NAME2, DEPARTMENT2, SALARY2);
            Employee e7 = serviceImp.add(F_NAME1, L_NAME3, DEPARTMENT2, SALARY2);
            Employee e8 = serviceImp.add(F_NAME1, L_NAME4, DEPARTMENT2, SALARY2);
            Employee e9 = serviceImp.add(F_NAME1, L_NAME5, DEPARTMENT2, SALARY2);
            Employee e10 = serviceImp.add(F_NAME2, L_NAME1, DEPARTMENT2, SALARY2);
            Employee e11 = serviceImp.add(F_NAME2, L_NAME3, DEPARTMENT2, SALARY2);
        });
    }

    @Test
    public void removeEmployee() throws BadRequestException {
        Employee eAdd = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
        eAdd = serviceImp.remove(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
        assertEquals(eAdd, null);

    }

    @Test
    public void employeeNotFoundException() throws BadRequestException {
        assertThrows(EmployeeNotFoundException.class, () -> {
            serviceImp.remove(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);

        });
    }

    @Test
    public void findEmployee() throws BadRequestException {
        Employee e1 = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
        Employee e2 = serviceImp.find(F_NAME1, L_NAME1);
        assertEquals(e1, e2);
    }

    @Test
    public void findEmployeeNotFoundException() throws BadRequestException {
        assertThrows(EmployeeNotFoundException.class, () -> {
            Employee e1 = serviceImp.find(F_NAME1, L_NAME3);
        });
    }

    @Test
    public void allEmployee() throws BadRequestException {
        Employee e1 = serviceImp.add(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
        Employee e2 = serviceImp.add(F_NAME3, L_NAME3, DEPARTMENT1, SALARY1);
        Employee e3 = serviceImp.add(F_NAME5, L_NAME5, DEPARTMENT2, SALARY2);
        Employee e4 = serviceImp.add(F_NAME4, L_NAME4, DEPARTMENT2, SALARY2);
        List<Employee> actual = serviceImp.allEmployee();
        assertTrue(EMPLOYEE_LIST.containsAll(actual));
    }
}
