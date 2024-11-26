import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InputRandomGenerator {
    private final Random random = new Random();

    // набор случайных данных
    private static final String[] automobileBrands = {"BMW", "Mercedes", "Opel", "Audi", "Toyota",
            "LADA", "Hundai", "Honda"};
    private static final String[] bookName = {"Преступление и наказание", "Война и мир", "1984",
            "Гарри Поттер", "Мастера и Маргарита", "Властелин Колец"};
    private static final String[] authors = {"Федор Достоевский", "Лев Толстой", "Джордж Оруэлл",
            "Джоан Роулинг", "Михаил Булгаков", "Джон Рональд Руэл Толкин"};
    private static final String[] rootVegetableNames = {"Морковь", "Картофель",
            "Редис", "Свекла", "Тыква", "Лук", "Сельдерей"};
    private static final String[] rootVegetableColors = {"Оранжевый", "Красный", "Желтый", "Белый", "Зеленый"};

    // Метод для генерации объектов
    public List<CustomClass> generateRandomObjects(CustomClassType type, int numberOfObjects) {
        List<CustomClass> objects = new ArrayList<>();

        for (int i = 0; i < numberOfObjects; i++) {
            switch (type) {
                case AUTOMOBILE:
                    objects.add(generateRandomAutomobile());
                    break;
                case BOOK:
                    objects.add(generateRandomBook());
                    break;
                case ROOT_VEGETABLE:
                    objects.add(generateRandomRootVegetable());
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип объекта.");
            }
        }

        return objects;
    }

    // Генерация случайного автомобиля
    private Automobile generateRandomAutomobile() {
        int power = random.nextInt(300) + 100; // Мощность от 100 до 400 л.с.
        String brand = automobileBrands[random.nextInt(automobileBrands.length)];
        int year = random.nextInt(30) + 1990; // Год от 1990 до 2020
        return new Automobile(power, brand, year);
    }

    // Генерация случайной книги
    private Book generateRandomBook() {

        String author = authors[random.nextInt(authors.length)];
        String nameBook = bookName[random.nextInt(bookName.length)];
        int year = random.nextInt(120) + 1900; // Год от 1900 до 2020
        return new Book(author, nameBook, year);
    }

    // Генерация случайного корнеплода
    private RootVegetable generateRandomRootVegetable() {
        String color = rootVegetableColors[random.nextInt(rootVegetableColors.length)];
        String name = rootVegetableNames[random.nextInt(rootVegetableNames.length)];
        int weight = random.nextInt(1000) + 100; // Вес от 100 до 1100 грамм

        return new RootVegetable(color, name, weight);
    }
}

