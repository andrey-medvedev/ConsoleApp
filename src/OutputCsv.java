import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputCsv {

    // Метод для экспорта списка объектов в CSV
    public static <T extends CsvConvertable> void exportToCSV(List<T> objects, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {

            // Проверка на заполненность списка, если не пустой, то добавляем заголовки
            if (!objects.isEmpty()) {
                String headers = objects.get(0).getCSVHeaders(); // Получение заголовков
                writer.append(headers).append("\n");
            }

            // Запись данных каждого объекта в файл
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
