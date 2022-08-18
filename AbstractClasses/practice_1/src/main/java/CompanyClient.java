public class CompanyClient extends Client {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void take(double amount) {
        double COMMISSION = 0.01;
        super.take(amount + (amount* COMMISSION));
    }
}
