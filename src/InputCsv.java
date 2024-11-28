import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputCsv {

    public static <T> List<T> importFromCSV(String fileName, Class<T> clazz) {
        List<T> objects = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {

            if (!scanner.hasNextLine()) {
                System.out.println("Ошибка: Файл пустой.");
                return objects;
            }

            String header = scanner.nextLine().trim();
            if (!isValidHeader(header, clazz)) {
                System.out.println("Ошибка: Заголовок файла не соответствует ожидаемому формату для " + clazz.getSimpleName());
                return objects;
            }



            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] fields = line.split(",");
                boolean valid = true;

                try {
                    if (clazz == Automobile.class && fields.length == 3) {
                        int power = Integer.parseInt(fields[0].trim());
                        String model = fields[1].trim();
                        int yearOfProduction = Integer.parseInt(fields[2].trim());
                        Automobile automobile = new Automobile(power, model, yearOfProduction);
                        objects.add((T) automobile);
                    } else if (clazz == Book.class && fields.length == 3) {
                        String title = fields[0].trim();
                        String author = fields[1].trim();
                        int pages = Integer.parseInt(fields[2].trim());
                        Book book = new Book(title, author, pages);
                        objects.add((T) book);
                    } else if (clazz == RootVegetable.class && fields.length == 3) {
                        String name = fields[0].trim();
                        String color = fields[1].trim();
                        int weight = Integer.parseInt(fields[2].trim());
                        RootVegetable rootVegetable = new RootVegetable(name, color, weight);
                        objects.add((T) rootVegetable);
                    } else {
                        valid = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Некорректный формат числового значения в строке: " + line);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("Ошибка: Строка пропущена из-за несоответствия формату: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл '" + fileName + "' не найден" );
        } catch (Exception e) {
            System.out.println("Ошибка: Произошла непредвиденная ошибка при чтении файла. " + e.getMessage());
        }

        return objects;
    }


    private static boolean isValidHeader(String header, Class<?> clazz) {

        String cleanedHeader = header.replaceAll("\\s+", "");

        switch (clazz.getSimpleName()) {
            case "Automobile":
                return cleanedHeader.equalsIgnoreCase("Мощность,Модель,Годвыпуска");
            case "Book":
                return cleanedHeader.equalsIgnoreCase("Автор,Названиекниги,Количествостраниц");
            case "RootVegetable":
                return cleanedHeader.equalsIgnoreCase("Типкорнеплода,Цвет,Вес(вграммах)");
            default:
                return false;
        }
    }
}
