public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Пицца", 100, 600.00);
        basket.print("Milk");
        Basket basket1 = new Basket();
        basket1.add("holly shit",10, 5,0);
        basket1.add("Квас",50);
        Basket k  = new Basket(660);
        k.add("lkkl",20);
        basket1.print("Milk");
        k.print("Milk");
        System.out.println("кол-во карзин " + Basket.getCount());
        System.out.println("Цена корзин " + Basket.getTotalPriceAllBasket());
        System.out.println("Кол-во товаров " + Basket.getCountItemsInBasket());
        System.out.println("Средняя стоимость товароыв " + Basket.averagePriceItems());
    }
}
