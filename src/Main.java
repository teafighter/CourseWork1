public class Main {
    public static void main(String[] args) {

        Employee[] employeeDatabase = new Employee[10];

        Employee ivanov1 = new Employee("Ivanov Ivan Ivanovich", 1, 100000); // создаем нового сотрудника
        employeeDatabase[ivanov1.getId()] = ivanov1; // записываем его в массив сотрудников
        Employee petrov1 = new Employee("Petrov Petr Petrovich", 2, 120000);
        employeeDatabase[petrov1.getId()] = petrov1;
        Employee.printEmployees(employeeDatabase); // тестируем вывод всего массива сотрудников
        // далее тестируем методы
        System.out.println("Затраты на ЗП в месяц: " + Employee.calculateSalaryFund(employeeDatabase)); // тестируем подсчет фонда оплаты труда
        System.out.println("Сотрудник c минимальной ЗП: " + Employee.findMinSalary(employeeDatabase));
        System.out.println("Сотрудник c максимальной ЗП: " + Employee.findMaxSalary(employeeDatabase));
        System.out.println("Средняя ЗП: " + Employee.calculateAverageSalary(employeeDatabase));
        Employee.printEmployeesNames(employeeDatabase);
    }
}