// task 2
package Java.lab3;
import java.util.HashMap;

class Warehouse {
    private HashMap<String, Product> products = new HashMap<>();

    public void addProduct(String barcode, Product product) {
        products.put(barcode, product);
    }

    public Product getProduct(String barcode) {
        return products.get(barcode);
    }
}