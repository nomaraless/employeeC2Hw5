package nomaralessNomadEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceForTest {
    public static final String F_NAME1 = "NameOne";
    public static final String F_NAME2 = "NameTwo";
    public static final String F_NAME3 = "NameThree";
    public static final String F_NAME4 = "NameFour";
    public static final String F_NAME5 = "NameFive";

    public static final String L_NAME1 = "LustNameOne";
    public static final String L_NAME2 = "LustNameTwo";
    public static final String L_NAME3 = "LustNameThree";
    public static final String L_NAME4 = "LustNameFour";
    public static final String L_NAME5 = "LustNameFive";

    public static final int DEPARTMENT1 = 1;
    public static final int DEPARTMENT2 = 2;

    public static final int SALARY1 = 100000 ;
    public static final int SALARY2 = 500000 ;

    public static final Employee EMPLOYEE1 = new Employee(F_NAME1, L_NAME1, DEPARTMENT1, SALARY1);
    public static final Employee EMPLOYEE2 = new Employee(F_NAME3, L_NAME3, DEPARTMENT1, SALARY1);
    public static final Employee EMPLOYEE3 = new Employee(F_NAME5, L_NAME5, DEPARTMENT2, SALARY2);
    public static final Employee EMPLOYEE4 = new Employee(F_NAME4, L_NAME4, DEPARTMENT2, SALARY2);

    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(List.of(EMPLOYEE1, EMPLOYEE2, EMPLOYEE3, EMPLOYEE4));

    public static final List<Employee> EMPLOYEE_LIST_BY_DEPARTMENT = new ArrayList<>(List.of(EMPLOYEE3, EMPLOYEE4));


}
