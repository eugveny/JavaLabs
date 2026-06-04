package JavaLabs.lab8;
public class Main {

    public static void main(String[] args) {

        try {
            DataManager manager =
                    new DataManager();

            manager.registerDataProcessor(
                    new FilterProcessor());

            manager.registerDataProcessor(
                    new TransformProcessor());

            manager.registerDataProcessor(
                    new SortProcessor());

            manager.loadData("/home/evg/Projects/Java/lab8/input.txt");
            manager.processData();
            manager.saveData("/home/evg/Projects/Java/lab8/output.txt");

            System.out.println(
                    manager.getProcessedData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}