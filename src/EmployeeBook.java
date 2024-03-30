public class EmployeeBook {

    public EmployeeBook(int employeesNumber) {
        this.employeeBook = new Employee[employeesNumber];
    }

    public EmployeeBook(Employee[] employeeBook) { // вариант конструктора при наличии готового массива
        this.employeeBook = employeeBook; // (только для внутреннего пользования, поэтому private)
    }

    private final Employee[] employeeBook;

    // добавление нового сотрудника в массив
    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = newEmployee;
                System.out.println("Сотрудник " + employeeBook[i].getName() + " принят на работу");
                return true;
            }
        }
        System.out.println("Найм нового сотрудника невозможен, нет мест в штатном расписании");
        return false;
    }

    // поиск сотрудника по id
    public Employee findEmployee(int id) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
        }
        System.out.println("Сотрудник не найден");
        return null;
    }

    // увольнение сотрудника
    public boolean removeEmployee(int id) {
        Employee employeeToRemove = findEmployee(id);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].equals(findEmployee(id))) {
                System.out.println("Cотрудник " + employeeBook[i].getName() + " уволен");
                employeeBook[i] = null;
                return true;
            }
        }
        System.out.println("Сотрудник не найден, увольнение невозможно");
        return false;
    }

    // вывод всей базы сотрудников
    public void printEmployees() {
        System.out.println("Полная информация о сотрудниках компании:");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // расчет фонда оплаты труда
    public double calculateSalaryFund() {
        double sum = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    // поиск минимальной зарплаты
    public Employee findMinSalary() {
        double minSalary = employeeBook[0].getSalary();
        Employee minSalaryEmployee = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getSalary() < minSalary) {
                    minSalaryEmployee = employee;
                    minSalary = employee.getSalary();
                }
            }
        }
        return minSalaryEmployee;
    }

    // поиск максимальной зарплаты
    public Employee findMaxSalary() {
        double maxSalary = employeeBook[0].getSalary();
        Employee maxSalaryEmployee = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getSalary() > maxSalary) {
                    maxSalaryEmployee = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxSalaryEmployee;
    }

    // поиск средней зарплаты
    public double calculateAverageSalary() {
        double averageSalary = 0;
        int numberOfEmployees = 0; // сначала посчитаем, сколько у нас всего сотрудников
        for (Employee employee : employeeBook) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        System.out.println("Всего сотрудников: " + numberOfEmployees);
        if (numberOfEmployees != 0) {
            averageSalary = Math.floor(calculateSalaryFund() / numberOfEmployees);
        }
        return averageSalary;
    }

    // вывод списка сотрудников
    public void printEmployeesNames() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    // индексирование зарплаты всем сотрудникам
    public void indexAllSalaries(double percent) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                double salary = Math.floor(employee.getSalary() * 100 * (1 + percent / 100) / 100);
                employee.setSalary(salary);
            }
        }
        System.out.println("Зарплата проиндексирована всем сотрудникам компании на " + percent + " процентов");
    }

    // вспомогательный метод для создания массива сотрудников в отделе
    public Employee[] deptEmployeesArray(int department) {
        Employee[] deptEmployees = new Employee[employeeBook.length];
        // создадим пустой массив для сотрудников отдела, их не больше, чем всего сотрудников в компании
        int numberOfDeptEmployees = 0; // пока не знаем, сколько сотрудников в отделе
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                deptEmployees[numberOfDeptEmployees] = employee;
                numberOfDeptEmployees++;
            }
        }
        return deptEmployees;
        // в рамках курсовой работы не будем усложнять метод и оставим массив сотрудников отдела
        // изначально заданной длины и не будем переделывать с отбрасыванием null значений в конце
    }

    // поиск минимальной зарплаты в отделе
    public Employee findMinDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.findMinSalary();
    }

    // поиск максимальной зарплаты в отделе
    public Employee findMaxDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.findMaxSalary();
    }

    // расчет фонда оплаты труда в отделе
    public double calculateDeptSalaryFund(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.calculateSalaryFund();
    }

    // поиск средней ЗП в отделе
    public double calculateAverageDeptSalary(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        return deptEmployeeBook.calculateAverageSalary();
    }

    // индексирование ЗП в отделе
    public void indexDeptSalaries(int department, double percent) { // не придумал, как красиво обернуть, поэтому напрямую меняем
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = Math.floor(employee.getSalary() * 100 * (1 + percent / 100) / 100);
                employee.setSalary(salary);
            }
        }
    }

    // вывод списка сотрудников отдела
    public void printDeptEmployeesNames(int department) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("Отдел " + department + ".");
        EmployeeBook deptEmployeeBook = new EmployeeBook(deptEmployees);
        deptEmployeeBook.printEmployeesNames();
    }

    // поиск сотрудников в отделе с меньшей ЗП
    public void findLessThanDeptSalary(int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("В отделе " + department + " З/П меньше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.getSalary() < salary) {
                    System.out.println("Сотрудник: " + employee.getName() + ", табельный номер: " + employee.getId() + ", З/П: " + employee.getSalary());
                }
            }
        }
    }

    // поиск сотрудников в отделе с большей ЗП
    public void findBiggerThanDeptSalary(int department, double salary) {
        Employee[] deptEmployees = deptEmployeesArray(department);
        System.out.println("В отделе " + department + " З/П больше, чем " + salary + " у следующих сотрудников:");
        for (Employee employee : deptEmployees) {
            if (employee != null) {
                if (employee.getSalary() > salary) {
                    System.out.println("Сотрудник: " + employee.getName() + ", табельный номер: " + employee.getId() + ", З/П: " + employee.getSalary());
                }
            }
        }
    }
}
