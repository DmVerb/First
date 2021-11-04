public class Product {
    private String name;
    public int price;

    public Product(String name, String barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    private final String barCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
