import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class InputCsv {

    public static <T> List<T> importFromCSV(String fileName, Class<T> clazz) throws FileNotFoundException {
        List<T> objects = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {

            if (!scanner.hasNextLine()) {
                System.out.println("Ошибка: Файл пустой");
                return objects;
            }

            String header = scanner.nextLine();

            // Проверяем на совпадение
            if (!isValidHeader(header, clazz)) {
                System.out.println("Ошибка: Заголовок не соответствует ожидаемому формату.");
                return objects;
            }


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                boolean valid = true;

                if (clazz == Automobile.class) {
                    if (fields.length == 3) {
                        try {

                            int power = Integer.parseInt(fields[0]);
                            String model = fields[1];
                            int yearOfProduction = Integer.parseInt(fields[2]);
                            Automobile automobile = new Automobile(power, model, yearOfProduction);
                            objects.add((T) automobile);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка в данных для типа АВТОМОБИЛИ: " + e.getMessage());
                            valid = false;
                        }
                    } else {
                        valid = false;
                    }
                } else if (clazz == Book.class) {
                    if (fields.length == 3) {
                        try {
                            String title = fields[0];
                            String author = fields[1];
                            int pages = Integer.parseInt(fields[2]);
                            Book book = new Book(title, author, pages);
                            objects.add((T) book);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка в данных для типа КНИГИ: " + e.getMessage());
                            valid = false;
                        }
                    } else {
                        valid = false;
                    }
                } else if (clazz == RootVegetable.class) {
                    if (fields.length == 3) {
                        try {

                            String name = fields[0];
                            String color = fields[1];
                            int weight = Integer.parseInt(fields[2]);
                            RootVegetable rootVegetable = new RootVegetable(name, color, weight);
                            objects.add((T) rootVegetable);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка в данных для типа КОРНЕПЛОДЫ: " + e.getMessage());
                            valid = false;
                        }
                    } else {
                        valid = false;
                    }
                }

                if (!valid) {
                    System.out.println("Ошибка! Присутсвует пропуск строк.");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName + "");
        }

        return objects;
    }

    // Проверяем заголовки для валидации файлов
    private static boolean isValidHeader(String header, Class<?> clazz) {
        switch (clazz.getSimpleName()) {
            case "Automobile":
                return header.equals("Мощность, Модель, Год выпуска");
            case "Book":
                return header.equals("Автор, Название книги, Количество страниц");
            case "RootVegetable":
                return header.equals("Тип корнеплода, Цвет, Вес (в граммах)");
            default:
                return false;
        }
    }
}
