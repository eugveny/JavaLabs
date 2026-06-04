//task 3
package Java.lab6;
import java.util.LinkedList;
import java.util.HashMap;

class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class StoreSales {

    LinkedList<Product> sales =
            new LinkedList<>();

    public void addSale(Product product) {
        sales.add(product);
    }

    public void printSales() {
        System.out.println("\nСписок продаж:");

        for (Product product : sales) {

            System.out.println(
                    product.getName()
                    + " - "
                    + product.getPrice()
                    + " руб."
            );
        }
    }

    public double getTotalSalesAmount() {

        double total = 0;

        for (Product product : sales) {
            total += product.getPrice();
        }

        return total;
    }

    public String getMostPopularProduct() {

        HashMap<String, Integer> counter =
                new HashMap<>();

        for (Product product : sales) {

            String name = product.getName();

            if (!counter.containsKey(name)) {
                counter.put(name, 1);
            } else {
                counter.put(
                        name,
                        counter.get(name) + 1
                );
            }
        }

        String bestProduct = "";
        int maxSales = 0;

        for (String name : counter.keySet()) {

            int salesCount =
                    counter.get(name);

            if (salesCount > maxSales) {

                maxSales = salesCount;
                bestProduct = name;
            }
        }

        return bestProduct;
    }

    public static void main(String[] args) {

        StoreSales store =
                new StoreSales();

        Product bread =
                new Product("Хлеб", 50);

        Product milk =
                new Product("Молоко", 80);

        Product cheese =
                new Product("Сыр", 250);

        store.addSale(bread);
        store.addSale(bread);
        store.addSale(bread);

        store.addSale(milk);
        store.addSale(milk);

        store.addSale(cheese);

        store.printSales();

        System.out.println(
                "\nОбщая сумма продаж: "
                + store.getTotalSalesAmount()
                + " руб."
        );

        System.out.println(
                "Самый популярный товар: "
                + store.getMostPopularProduct()
        );
    }
}