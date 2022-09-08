public class Manager implements Employee {

    private int salary = 50000;
    private int monthIncome;

    private static final double bonus = 0.05;

    private static final int minMonthIncome = 115_000;
    private static final int maxMonthIncome = 140_000;

    public Manager() {
        monthIncome = (int) Math.round(Math.random() * (maxMonthIncome - minMonthIncome) + minMonthIncome);
        salary += monthIncome * bonus;
        monthIncome += monthIncome;
    }

    public double getSales() {
        return monthIncome;
    }

    @Override
    public int getMoneySalary() {
        return salary;
    }
}

