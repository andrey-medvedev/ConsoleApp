import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputCsv {


    public static <T extends CsvConvertable> void exportToCSV(ArrayList<T> objects, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {


            if (!objects.isEmpty()) {
                String headers = objects.get(0).getCSVHeaders();
                writer.append(headers).append("\n");
            }

            for (T object : objects) {
                writer.append(object.toCSV()).append("\n");
            }

            System.out.println("Данные успешно экспортированы в файл " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при записи в файл.");
        }
    }
}
