public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double weight = 0;
    public static int totalPriceAllBasket = 0;
    public static int countItemsInBasket;
    public static int averagePriceItems;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getTotalPriceAllBasket() {
        return totalPriceAllBasket;
    }

    public static void increaseTotalPriceAllBasket(int price, int count) {
        Basket.totalPriceAllBasket = Basket.totalPriceAllBasket + (price * count);
    }

    public static int getCountItemsInBasket() {
        return countItemsInBasket;
    }

    public static void increaseCountItemsInBasket(int count) {
        Basket.countItemsInBasket = Basket.countItemsInBasket + count;
    }

    public static int averagePriceItems (){
        averagePriceItems = totalPriceAllBasket / countItemsInBasket;
        return averagePriceItems;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
        increaseTotalPriceAllBasket(price, 1);
        increaseCountItemsInBasket(1);
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1);
        increaseTotalPriceAllBasket(price, 1);
        increaseCountItemsInBasket(1);
        this.weight += weight;
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        increaseTotalPriceAllBasket(price, count);
        increaseCountItemsInBasket(count);
        this.weight += weight;
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
    public double getWeight() {
        return weight;
    }
}
