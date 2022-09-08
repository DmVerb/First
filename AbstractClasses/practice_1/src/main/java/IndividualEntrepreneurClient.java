public class IndividualEntrepreneurClient extends Client {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void put(double amount) {
        double COMMISSION = 0.01;
        double COMMISSION_OVER_1000 = 0.005;
        if (amount < 1000) {
            super.put(amount - (amount * COMMISSION));
        } else {
            super.put(amount - (amount * COMMISSION_OVER_1000));
        }
    }
}
