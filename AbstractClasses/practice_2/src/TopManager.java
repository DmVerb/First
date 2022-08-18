public class TopManager implements Employee {

    private double fixedSalary = 150000;

    private final double bonus = 1.5;

    public  TopManager() {
        if (Company.allMonthIncome > 1000000) {
            fixedSalary += fixedSalary * bonus;
        }else {
        }
    }

    @Override
    public String toString() {
        return fixedSalary + " руб.\n" ;
    }

    @Override
    public double getMoneySalary() {
        return fixedSalary;
    }
}
