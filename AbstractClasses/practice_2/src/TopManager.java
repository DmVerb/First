public class TopManager implements Employee {

    private final static int fixedSalary = 150000;
    private final Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMoneySalary() {
        if (company.getIncome() > 1000000) {
            return (int) (fixedSalary * 1.5);
        }
        return fixedSalary;
    }
}
