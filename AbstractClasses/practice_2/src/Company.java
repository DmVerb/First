import java.util.*;

public class Company {

    private final List<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }


    public List<Employee> getTopSalaryStaff(int count) {
        return getList(count, Comparator.reverseOrder());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getList(count, Comparator.naturalOrder());
    }

    private List<Employee> getList(int count, Comparator<Employee> cmp) {
        if (count < 0) {
            return Collections.emptyList();
        }
        if (count > employees.size()) {
            count = employees.size();
        }
        employees.sort(cmp);
        return new ArrayList<>(employees.subList(0, count));
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employeeList) {
        for (Employee a : employeeList) {
            hire(a);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        int income = 0;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                income += ((Manager) e).getSales();
            }
        }
        return income;
    }

}
