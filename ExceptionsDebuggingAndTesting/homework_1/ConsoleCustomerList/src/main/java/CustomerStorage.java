import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new AssertionError("Wrong format");
        }
        if (!Pattern.matches("[A-Za-z0-9]+@+[A-Za-z0-9]+\\.+[A-Za-z]{2,}", components[INDEX_EMAIL])) {
            throw new ArrayStoreException("Wrong email");
        }
        if (!Pattern.matches("^((\\+7|7|8)+([0-9]){10})$", components[INDEX_PHONE])) {
            throw new ArrayStoreException("wrong phone");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}