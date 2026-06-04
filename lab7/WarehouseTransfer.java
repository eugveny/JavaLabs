// задание 3, вариант 2
package JavaLabs.lab7;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Product {
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

class Warehouse {
    private final Queue<Product> products = new LinkedList<>();
    private static final int MAX_WEIGHT = 150;
    private int currentWeight = 0;

    public void addProduct(Product product) {
        products.add(product);
    }

    public synchronized Product takeProduct() {
        if (products.isEmpty()) {
            return null;
        }

        Product product = products.peek();

        if (currentWeight + product.getWeight() > MAX_WEIGHT) {
            System.out.println(
                    "\nНабрано " + currentWeight +
                    " кг. Машина отправляется.\n"
            );
            currentWeight = 0;
        }

        products.poll();
        currentWeight += product.getWeight();
        return product;
    }
}

interface Loader extends Runnable {
}

class LoaderRealization implements Loader {
    private final String name;
    private final Warehouse warehouse;

    public LoaderRealization(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product product = warehouse.takeProduct();

            if (product == null) {
                break;
            }

            System.out.println(
                    name + " переносит товар: "
                    + product.getName()
                    + " (" + product.getWeight()
                    + " кг)"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(name + " закончил работу.");
    }
}

public class WarehouseTransfer {

    public static void main(String[] args)
            throws InterruptedException {

        Warehouse warehouse = new Warehouse();

        warehouse.addProduct(new Product("Холодильник", 50));
        warehouse.addProduct(new Product("Телевизор", 20));
        warehouse.addProduct(new Product("Стиральная машина", 40));
        warehouse.addProduct(new Product("Шкаф", 60));
        warehouse.addProduct(new Product("Стол", 30));
        warehouse.addProduct(new Product("Стул", 10));
        warehouse.addProduct(new Product("Диван", 70));
        warehouse.addProduct(new Product("Тумба", 15));

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        executor.execute(new LoaderRealization("Грузчик 1", warehouse));
        executor.execute(new LoaderRealization("Грузчик 2", warehouse));
        executor.execute(new LoaderRealization("Грузчик 3", warehouse));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("\nВсе товары перенесены.");
    }
}