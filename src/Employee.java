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

    // вывод всей базы сотрудников
    public static void printEmployees(Employee[] employeeDatabase) {
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // расчет фонда оплаты труда
    public static double calculateSalaryFund(Employee[] employeeDatabase) {
        double sum = 0;
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                sum += employee.salary;
            }
        }
        return sum;
    }

    // поиск минимальной зарплаты
    public static Employee findMinSalary(Employee[] employeeDatabase) {
        double minSalary = 0;
        Employee minSalaryEmployee = null;
        boolean firstValueToCompareIsSet = false;
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                if (!firstValueToCompareIsSet) { // задаем начальное значение для сравнения
                    minSalary = employee.salary;
                    minSalaryEmployee = employee;
                    firstValueToCompareIsSet = true;
                }
                if (employee.salary < minSalary) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    // поиск максимальной зарплаты
    public static Employee findMaxSalary(Employee[] employeeDatabase) {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        boolean firstValueToCompareIsSet = false;
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                if (!firstValueToCompareIsSet) { // задаем начальное значение для сравнения
                    maxSalary = employee.salary;
                    maxSalaryEmployee = employee;
                    firstValueToCompareIsSet = true;
                }
                if (employee.salary > maxSalary) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    // поиск средней зарплаты
    public static double calculateAverageSalary(Employee[] employeeDatabase) {
        double averageSalary = 0;
        int numberOfEmployees = 0; // сначала посчитаем, сколько у нас всего сотрудников
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        System.out.println("Всего сотрудников: " + numberOfEmployees);
        if (numberOfEmployees != 0) {
            averageSalary = calculateSalaryFund(employeeDatabase) / numberOfEmployees;
        }
        return averageSalary;
    }

    // вывод списка сотрудников
    public static void printEmployeesNames(Employee[] employeeDatabase) {
        System.out.println("Список сотрудников:");
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                System.out.println(employee.name);
            }
        }
    }
}
