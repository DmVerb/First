import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company1 = new Company();
        for (int i = 0; i < 180; i++) {
            company1.hire(new Operator());
        }
        List<Employee> newStaff = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newStaff.add(new TopManager(company1));
        }
        for (int i = 0; i < 80; i++) {
            newStaff.add(new Manager());
        }
        company1.hireAll(newStaff);

        List<Employee> topSalaryStaff = company1.getTopSalaryStaff(13);
        for (Employee e : topSalaryStaff){
            System.out.println(e.getMoneySalary() + " руб.");
        }
        List<Employee> lowestSalaryStaff = company1.getLowestSalaryStaff(30);
        for (Employee e : lowestSalaryStaff){
            System.out.println(e.getMoneySalary() + " руб.");
        }
        System.out.println(company1.getIncome());
        List<Employee> employees = company1.getEmployees();
        for (int i = 0; i < 135; i++) {
            company1.fire(employees.get(i));
        }
        List<Employee> topSalaryStaff1 = company1.getTopSalaryStaff(13);
        for (Employee e : topSalaryStaff1){
            System.out.println(e.getMoneySalary() + " руб.");
        }
        List<Employee> lowestSalaryStaff1 = company1.getLowestSalaryStaff(30);
        for (Employee e : lowestSalaryStaff1){
            System.out.println(e.getMoneySalary() + " руб.");
        }
        System.out.println(company1.getIncome() );
    }
}
