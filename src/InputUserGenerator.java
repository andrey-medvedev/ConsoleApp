import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUserGenerator {
    private final Scanner scanner;

    public InputUserGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<CustomObject> readObjects(CustomClassType type, int numberOfObjects) {
        List<CustomObject> objects = new ArrayList<>();

        for (int i = 0; i < numberOfObjects; i++) {
            System.out.printf("Введите данные для объекта %d/%d типа %s: \n", i + 1, numberOfObjects, type);
            scanner.nextLine(); // очистка буфера

            switch (type) {
                case AUTOMOBILE:
                    objects.add(readAutomobile());
                    break;
                case BOOK:
                    objects.add(readBook());
                    break;
                case ROOT_VEGETABLE:
                    objects.add(readRootVegetable());
                    break;
                default:
                    System.out.println("Неизвестный тип объекта.");
            }
        }

        return objects;
    }

    private Automobile readAutomobile() {
        int power = -1;
        int year = -1;
        String brand = "";

        // Ввод данных для автомобиля с проверкой
        while (power <= 0) {
            System.out.println("Введите мощность (л.с.): ");
            if (scanner.hasNextInt()) {
                power = scanner.nextInt();
                if (power <= 0) {
                    System.out.println("Мощность должна быть положительным числом.");
                }
            } else {
                System.out.println("Неверный формат данных, введите целое число.");
                scanner.nextLine(); // очистка неправильного ввода
            }
        }

        scanner.nextLine(); // очистка буфера после ввода числа
        while (brand.isEmpty()) {
            System.out.println("Введите название автомобиля: ");
            brand = scanner.nextLine();
            if (brand.isEmpty()) {
                System.out.println("Название не может быть пустым.");
            }
        }

        while (year < 1900) {
            System.out.println("Введите год выпуска автомобиля: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 1900) {
                    System.out.println("Год выпуска должен быть больше 1900.");
                }
            } else {
                System.out.println("Неверный формат данных, введите целое число.");
                scanner.next(); // очистка неправильного ввода
            }
        }

        return new Automobile(power, brand, year);
    }

    private Book readBook() {
        String bookName = "";
        String author = "";
        int year = -1;

        // Ввод данных для книги с проверкой
        while (bookName.isEmpty()) {
            System.out.println("Введите название книги: ");
            bookName = scanner.nextLine();
            if (bookName.isEmpty()) {
                System.out.println("Название книги не может быть пустым.");
            }
        }

        while (author.isEmpty()) {
            System.out.println("Введите информацию об авторе: ");
            author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.println("Автор не может быть пустым.");
            }
        }

        while (year <= 0) {
            System.out.println("Введите год выпуска книги: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year <= 0) {
                    System.out.println("Год выпуска должен быть положительным числом.");
                }
            } else {
                System.out.println("Неверный формат данных, введите целое число.");
                scanner.next(); // очистка неправильного ввода
            }
        }

        return new Book(bookName, author, year);
    }

    private RootVegetable readRootVegetable() {
        String name = "";
        String color = "";
        int weight = -1;

        // Ввод данных для корнеплода с проверкой


        while (color.isEmpty()) {
            System.out.println("Введите цвет корнеплода: ");
            color = scanner.nextLine();
            if (color.isEmpty()) {
                System.out.println("Цвет не может быть пустым.");
            }
        }
        while (name.isEmpty()) {
            System.out.println("Введите название корнеплода: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Название не может быть пустым.");
            }
        }

        while (weight <= 0) {
            System.out.println("Введите вес корнеплода (в граммах): ");
            if (scanner.hasNextInt()) {
                weight = scanner.nextInt();
                if (weight <= 0) {
                    System.out.println("Вес должен быть положительным числом.");
                }
            } else {
                System.out.println("Неверный формат данных, введите целое число.");
                scanner.next(); // очистка буфера
            }
        }

        return new RootVegetable(color, name, weight);
    }
}
