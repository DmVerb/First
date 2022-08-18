import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    String name;
    ArrayList<Employee> employees = new ArrayList<>();
    public static double allMonthIncome;

    public Company(String name) {
        this.name = name;
        allMonthIncome = 0;
    }

    public Company(String name, int operator, int manager, int topManager) {
        this.name = name;
        for (int i = 0; i < operator; i++) {
            hire(new Operator());
        }
        for (int i = 0; i < manager; i++) {
            hire(new Manager());
        }
        for (int i = 0; i < topManager; i++) {
            hire(new TopManager());
        }
        allMonthIncome = 0;
    }


    public ArrayList<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> sortList = new ArrayList<>(employees);
        Collections.sort(sortList, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getMoneySalary() - o2.getMoneySalary());
            }
        });
        Collections.reverse(sortList);
        ArrayList<Employee> result = new ArrayList<Employee>();
        for (int i = 0; i < count; i++) {
            result.add(sortList.get(i));
        }
        return result;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> sortList = new ArrayList<>(employees);
        Collections.sort(sortList, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getMoneySalary() - o2.getMoneySalary());
            }
        });
        ArrayList<Employee> result = new ArrayList<Employee>();
        for (int i = 0; i < count; i++) {
            result.add(sortList.get(i));
        }
        return result;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        employees.addAll(employes);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void fire50Percent() {
        int i = employees.size();
        for (int j = employees.size(); j >= 0; j--) {
            if (j % 2 == 0)
                employees.remove(employees.get(j));
        }
    }

    public double getIncome() {
        return allMonthIncome;
    }

    @Override
    public String toString() {
        return "Company " + name + ", ЗП сотрудников " + employees.toString();
    }
}
