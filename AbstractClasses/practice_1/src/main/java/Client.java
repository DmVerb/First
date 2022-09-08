public abstract class Client {

    public double acountClient = 0D;

    public double getAmount() {
        return acountClient;
    }

    public void put(double amount) {
        if (amount > 0) {
            acountClient += amount;
        }
    }

    public void take(double amount) {
        if (acountClient > amount) {
            acountClient -= amount;
        }
    }

    public abstract String getName();
    public abstract String getInfo();

}
