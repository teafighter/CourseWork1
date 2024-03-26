public class Main {
    public static void main(String[] args) {

        Employee[] employeeDatabase = new Employee[10];
        // далее создадим массив сотрудников
        Employee ivanov1 = new Employee("Иванов Иван Иванович", 1, 100000); // создаем нового сотрудника
        employeeDatabase[ivanov1.getId()] = ivanov1; // записываем его в массив сотрудников
        Employee petrov1 = new Employee("Петров Петр Петрович", 2, 120000);
        employeeDatabase[petrov1.getId()] = petrov1;
        Employee ivanov2 = new Employee("Иванов Иван Иванович", 1, 100000); // создадим однофамильца Иванова Первого
        employeeDatabase[ivanov2.getId()] = ivanov2;
        Employee sidorov1 = new Employee("Сидоров Сидор Сидорович", 3, 123456);
        employeeDatabase[sidorov1.getId()] = sidorov1;
        Employee test = new Employee("test", 1, 999999); // создадим тестовую запись
        employeeDatabase[test.getId()] = test;
        employeeDatabase[test.getId()] = null; // чтобы тут же его уволить и создать дырку в перечне id
        Employee nazarova1 = new Employee("Назарова Наталья Сергеевна", 2, 321654);
        employeeDatabase[nazarova1.getId()] = nazarova1;
        Employee stepanov1 = new Employee("Степанов Евгений Васильевич", 2, 999999);
        employeeDatabase[stepanov1.getId()] = stepanov1;

//        Employee.printEmployees(employeeDatabase); // тестируем вывод всего массива сотрудников
//        System.out.println(ivanov1.equals(ivanov2)); // сравним двух Ивановых
//        System.out.println("Затраты на ЗП в месяц: " + Employee.calculateSalaryFund(employeeDatabase)); // тестируем подсчет фонда оплаты труда
//        System.out.println("Сотрудник c минимальной ЗП: " + Employee.findMinSalary(employeeDatabase));
//        System.out.println("Сотрудник c максимальной ЗП: " + Employee.findMaxSalary(employeeDatabase));
//        System.out.println("Средняя ЗП: " + Employee.calculateAverageSalary(employeeDatabase));
//        Employee.printEmployeesNames(employeeDatabase);
//        Employee.indexAllSalaries(employeeDatabase, 10);
//        Employee.printEmployees(employeeDatabase); // проверим, что ЗП проиндексирована
//        System.out.println(Employee.findMinDeptSalary(employeeDatabase, 2));
//        Employee.printEmployees(Employee.deptEmployeesArray(employeeDatabase, 2)); // тестируем вывод на печать сотрудников отдела используя общий метод печати
//        System.out.println(Employee.findMinDeptSalary(employeeDatabase, 2)); // тестируем поиск минимальной ЗП в отделе
//        Employee.printDeptEmployeesNames(employeeDatabase, 2); // тестируем вывод на печать сотрудников отдела
//        Employee.indexDeptSalaries(employeeDatabase, 2, 10); // тестируем индексирование ЗП всему отделу
//        Employee.printDeptEmployeesNames(employeeDatabase, 2); // проверяем, что ЗП проиндексирована
//        System.out.println("Средняя ЗП: " + Employee.calculateAverageDeptSalary(employeeDatabase,2)); // тестируем подсчет средней ЗП в отделе
//        Employee.findLessThanDeptSalary(employeeDatabase, 2, 400000); // тестируем уровень зарплат
//        Employee.findBiggerThanDeptSalary(employeeDatabase, 2, 200000);

    }
}