public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Пицца", 100, 600.00);
        basket.print("Milk");
    }
}
