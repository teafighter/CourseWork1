import java.util.Objects;

public class Employee {

    private final String name; // ФИО
    private int department; // отдел (от 1 до 5)
    private double salary; // зарплата
    private final int id; // табельный номер
    private static int counter; // счетчик


    // создание нового сотрудника
    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = counter++;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    @Override // у каждого сотрудника уникальный id, поэтому сравнивать будем только их
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + name + ", табельный номер: " + id + ", отдел: " + department + ", З/П: " + salary;
    }
}
