package JavaLabs.lab8;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {

    private List<Object> processors =
            new ArrayList<>();

    private List<Integer> data =
            new ArrayList<>();

    private List<Integer> processedData =
            new ArrayList<>();

    public void registerDataProcessor(
            Object processor) {
        processors.add(processor);
    }

    public void loadData(String source)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        String line;

        while ((line = reader.readLine()) != null) {
            data.add(Integer.parseInt(line));
        }
        reader.close();
    }

    public void processData()
            throws Exception {
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        processedData = new ArrayList<>(data);
        for (Object processor : processors) {
            // рефлексия (исследую класс во время работы)
            for (Method method :
                    processor.getClass()
                            .getDeclaredMethods()) {
                                
                if (method.isAnnotationPresent(
                        DataProcessor.class)) {
                    List<Integer> currentData =
                            processedData;

                    // задача в поток
                    Future<List<Integer>> future =
                            executor.submit(() -> (List<Integer>) // lambda (ЗвП)
                                method.invoke(processor, currentData));
                    processedData = future.get();
                }
            }
        }

        executor.shutdown();
    }

    public void saveData(String destination)
            throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(destination));

        for (Integer number :
                processedData) {
            writer.write(
                    number.toString());
            writer.newLine();
        }
        writer.close();
    }

    public List<Integer> getProcessedData() {
        return processedData;
    }
}