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
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                if (minSalary == 0) { // задаем начальное значение для сравнения
                    minSalary = employee.salary;
                    minSalaryEmployee = employee;
                }
                if (employee.salary < minSalary) {
                    minSalaryEmployee = employee;
                    minSalary = employee.salary;
                }
            }
        }
        return minSalaryEmployee;
    }

    // поиск максимальной зарплаты
    public static Employee findMaxSalary(Employee[] employeeDatabase) {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                if (maxSalary == 0) { // задаем начальное значение для сравнения
                    maxSalary = employee.salary;
                    maxSalaryEmployee = employee;
                }
                if (employee.salary > maxSalary) {
                    maxSalaryEmployee = employee;
                    maxSalary = employee.salary;
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
            averageSalary = Math.floor(calculateSalaryFund(employeeDatabase) / numberOfEmployees);
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

    // индексирование зарплаты всем сотрудникам
    public static void indexAllSalaries(Employee[] employeeDatabase, double percent) {
        for (Employee employee : employeeDatabase) {
            if (employee != null) {
                employee.salary = Math.floor(employee.salary * 100 * (1 + percent / 100) / 100);
            }
        }
    }

    // вспомогательный метод для создания массива сотрудников в отделе
    public static Employee[] deptEmployeesArray(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = new Employee[employeeDatabase.length];
        // создадим пустой массив для сотрудников отдела, их не больше, чем всего сотрудников в компании
        int numberOfDeptEmployees = 0; // пока не знаем, сколько сотрудников в отделе
        for (Employee employee : employeeDatabase) {
            if (employee != null && employee.department == department) {
                deptEmployees[numberOfDeptEmployees] = employee;
                numberOfDeptEmployees++;
            }
        }
        return deptEmployees;
        // в рамках курсовой работы не будем усложнять метод и оставим массив сотрудников отдела
        // изначально заданной длины и не будем переделывать с отбрасыванием null значений в конце
    }

    // поиск минимальной зарплаты в отделе
    public static Employee findMinDeptSalary(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        return findMinSalary(deptEmployees);
    }

    // поиск максимальной зарплаты в отделе
    public static Employee findMaxDeptSalary(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        return findMaxSalary(deptEmployees);
    }

    // расчет фонда оплаты труда в отделе
    public static double calculateDeptSalaryFund(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        return calculateSalaryFund(deptEmployees);
    }

    // поиск средней ЗП в отделе
    public static double calculateAverageDeptSalary(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        return calculateAverageSalary(deptEmployees);
    }

    // индексирование ЗП в отделе
    public static void indexDeptSalaries(Employee[] employeeDatabase, int department, double percent) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        indexAllSalaries(deptEmployees, percent);
    }

    // вывод списка сотрудников отдела
    public static void printDeptEmployeesNames(Employee[] employeeDatabase, int department) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        System.out.println("Отдел " + department + ":");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                System.out.println("Сотрудник: " + employee.name + ", табельный номер: " + employee.id + ", З/П: " + employee.salary);
            }
        }
    }

    // поиск сотрудников в отделе с меньшей ЗП
    public static void findLessThanDeptSalary(Employee[] employeeDatabase, int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        System.out.println("В отделе " + department + " З/П меньше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.salary < salary) {
                    System.out.println("Сотрудник: " + employee.name + ", табельный номер: " + employee.id + ", З/П: " + employee.salary);
                }
            }
        }
    }

    // поиск сотрудников в отделе с большей ЗП
    public static void findBiggerThanDeptSalary(Employee[] employeeDatabase, int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(employeeDatabase, department);
        System.out.println("В отделе " + department + " З/П больше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.salary > salary) {
                    System.out.println("Сотрудник: " + employee.name + ", табельный номер: " + employee.id + ", З/П: " + employee.salary);
                }
            }
        }
    }
}
