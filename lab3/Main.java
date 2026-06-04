// task 2's main
package Java.lab3;

class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>(7);
        table.put("apple", 5);

        System.out.println(table.get("apple"));

        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("123", new Product("Apple", 1.5, 100));

        System.out.println(warehouse.getProduct("123"));
    }
}