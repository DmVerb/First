public class Manager implements Employee {

    private double salary = 50000.0;

    private final double bonus = 0.05;

    private final int minMonthIncome = 115_000;
    private final int maxMonthIncome = 140_000;

    public Manager() {
        double monthIncome = Math.round(Math.random() * (maxMonthIncome - minMonthIncome) + minMonthIncome);
        salary += monthIncome * bonus;
        Company.allMonthIncome += monthIncome;
    }

    @Override
    public String toString() {
        return salary + " руб. \n";
    }

    @Override
    public double getMoneySalary() {
        return salary;
    }
}

