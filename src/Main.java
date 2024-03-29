public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);
        // далее создадим массив сотрудников
        Employee ivanov1 = new Employee("Иванов Иван Иванович", 1, 100000); // создаем нового сотрудника
        employeeBook.addEmployee(ivanov1); // записываем его в массив сотрудников
        Employee petrov1 = new Employee("Петров Петр Петрович", 2, 120000);
        employeeBook.addEmployee(petrov1);
        Employee ivanov2 = new Employee("Иванов Иван Иванович", 1, 100000); // создадим однофамильца Иванова Первого
        employeeBook.addEmployee(ivanov2);
        Employee sidorov1 = new Employee("Сидоров Сидор Сидорович", 3, 123456);
        employeeBook.addEmployee(sidorov1);
        Employee test = new Employee("test", 1, 999999); // создадим тестовую запись
        employeeBook.addEmployee(test);
        Employee nazarova1 = new Employee("Назарова Наталья Сергеевна", 2, 321654);
        employeeBook.addEmployee(nazarova1);
        Employee stepanov1 = new Employee("Степанов Евгений Васильевич", 2, 999999);
        employeeBook.addEmployee(stepanov1);

        // тестируем методы
        employeeBook.printEmployees(); // тестируем вывод всего массива сотрудников
        employeeBook.removeEmployee(4); // уволим test, создав дырку в массиве
        employeeBook.printEmployees();
        System.out.println("Затраты на ЗП в месяц: " + employeeBook.calculateSalaryFund()); // тестируем подсчет фонда оплаты труда
        System.out.println("Сотрудник c минимальной ЗП: " + employeeBook.findMinSalary());
        System.out.println("Сотрудник c максимальной ЗП: " + employeeBook.findMaxSalary());
        System.out.println("Средняя ЗП: " + employeeBook.calculateAverageSalary());
        employeeBook.printEmployeesNames(); // тестируем вывод имен сотрудников
        employeeBook.indexAllSalaries(10); // индексируем ЗП
        employeeBook.printEmployees(); // проверим, что ЗП проиндексирована
        System.out.println("В отделе 2 минимальную ЗП имеет " + employeeBook.findMinDeptSalary(2)); // тестируем поиск минимальной ЗП в отделе
        System.out.println("В отделе 2 максимальную ЗП имеет " + employeeBook.findMaxDeptSalary(2)); // тестируем поиск максимальной ЗП в отделе
        employeeBook.printDeptEmployeesNames(2); // тестируем вывод на печать сотрудников отдела
        employeeBook.indexDeptSalaries(2, 10); // тестируем индексирование ЗП всему отделу
        employeeBook.printDeptEmployeesNames(2); // проверяем, что ЗП проиндексирована
        System.out.println("Средняя ЗП: " + employeeBook.calculateAverageDeptSalary(2)); // тестируем подсчет средней ЗП в отделе
        employeeBook.findLessThanDeptSalary(2, 400000); // тестируем уровень зарплат
        employeeBook.findBiggerThanDeptSalary(2, 200000);

    }
}