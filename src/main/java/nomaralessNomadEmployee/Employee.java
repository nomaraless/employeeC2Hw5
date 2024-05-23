package nomaralessNomadEmployee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lustName;

    public Employee(String firstName, String lustName) {
        this.firstName = firstName;
        this.lustName = lustName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLustName() {
        return lustName;
    }

    public void setLustName(String lustName) {
        this.lustName = lustName;
    }

    public String getFullName() {
        return firstName + " " + lustName;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lustName='" + lustName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lustName, employee.lustName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lustName);
    }
}
