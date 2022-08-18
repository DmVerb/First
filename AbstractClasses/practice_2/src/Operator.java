public class Operator implements Employee {
    private double salary;

    public Operator() {
        salary = 50000;
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
