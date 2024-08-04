package nomaralessNomadEmployee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static nomaralessNomadEmployee.SourceForTest.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImpTest {
    @Mock
    private EmployeeServiceImp employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImp departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void maxSalaryByDepartmentTest() {
        when(employeeServiceMock.allEmployee())
                .thenReturn(EMPLOYEE_LIST);
        assertEquals(EMPLOYEE1, departmentService.maxSalary(1));
    }

    @Test
    public void minSalaryByDepartmentTest() {
        when(employeeServiceMock.allEmployee())
                .thenReturn(EMPLOYEE_LIST);
        assertEquals(EMPLOYEE3, departmentService.minSalary(2));
    }

    @Test
    public void sumSalaryByDepartmentTest() {
        when(employeeServiceMock.allEmployee())
                .thenReturn(EMPLOYEE_LIST);
        assertEquals(SALARY2 + SALARY2, departmentService.sumSalary(2));
    }

    @Test
    public void getAllByDepartmentTest() {
        when(employeeServiceMock.allEmployee())
                .thenReturn(EMPLOYEE_LIST);
        assertEquals(EMPLOYEE_LIST_BY_DEPARTMENT, departmentService.getAllByDepartment(2));
    }

}
