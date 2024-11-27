import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class BookBuilder implements Builder<Book> {

    private final ArrayList<Book> objects = new ArrayList<>();

    public BookBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя автора:");
            String author = validateBookAuthor(in.nextLine());
            System.out.println("Введите наименование книги:");
            String name = validateBookName(in.nextLine());
            System.out.println("Введите количество страниц:");
            int numberOfPages = validateBookNumberOfPages(Integer.parseInt(in.nextLine()));
            objects.add(new Book(author, name, numberOfPages));
        }
        return this;
    }

    public BookBuilder readValuesFromRandom(int number){
        objects.clear();
        Random rand = new Random();

        Object[][] books = {{"Достоевский Ф.М.", "Преступление и наказание",  465},
                {"Пушкин А.С.", "Капитанская дочка", 348},
                {"Лермонтов Р.М.", "Герой нашего времени", 183},
                {"Карамзин Н.М.", "Бедная Лиза", 279},
                {"Салтыков-Щедрин М.Е.", "Дикий помещик", 286}};

        for (int i = 0; i < number; i++) {
            Object[] book = books[rand.nextInt(books.length)];
            String author = validateBookAuthor((String) book[0]);
            String name = validateBookName((String) book[1]);
            int numberOfPages = validateBookNumberOfPages((int) book[2]);
            objects.add(new Book(author, name, numberOfPages));
        }
        return this;
    }

    public BookBuilder readValuesFromFile(String path){
        objects.clear();

        for (var book : CustomClassOperations.deserializeArray(path)) {
            validateBookAuthor(((Book) book).getAuthor());
            validateBookName(((Book) book).getName());
            validateBookNumberOfPages(((Book) book).getNumberOfPages());
            objects.add((Book) book);
        }

        if (objects.size() != Controller.getNumberOfObjects()){
            System.out.println("""
        Количество объектов в файле отлично от установленного в программе.
        Значение в настройках программы было обновлено!""");
            Controller.setNumberOfObjects(objects.size());
        }

        return this;
    }

    public ArrayList<Book> build(){
        return objects;
    }

    public static String validateBookAuthor(String author) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(!author.matches("^[А-Яа-яЁё., ]+$")) {
                System.out.println("Имя автора может содержать только кирилицу");
            } else if(!author.substring(0, author.length() - 5).matches("(Достоевский|достоевский|Пушкин|пушкин|" +
                    "Лермонтов|лермонтов|" +
                    "Карамзин|карамазин|Салтыков-Щедрин|салтыков-щедрин)")) {
                System.out.println("Имя автора не существует");
            } else {
                break;
            }
            System.out.println("Введите корректное имя автора книги");
            author = scanner.nextLine();
        }
        return author;
    }

    public static String validateBookName(String name) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(!name.matches("^[А-Яа-яЁё ]+$")) {
                System.out.println("Название книги может содержать только кириллицу");
            } else if(!name.matches("(Преступление и наказание|преступление и наказание|" +
                    "Капитанская дочка|капитанская дочка|Герой нашего времени|герой нашего времени" +
                    "|Бедная Лиза|бедная Лиза|Дикий помещик|дикий помещик)")) {
                System.out.println("Название книги не существует");
            } else {
                break;
            }
            System.out.println("Введите корректное имя автора книги");
            name = scanner.nextLine();
        }
        return name;
    }

    public static int validateBookNumberOfPages(int numberOfPages) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(numberOfPages < 100 || numberOfPages > 500) {
                System.out.println("Значение количества страниц в книге должно находиться в диапазоне 100 - 500 с.");
            } else {
                break;
            }
            System.out.println("Введите корректное количество страниц в книге");
            numberOfPages = scanner.nextInt();
        }
        return numberOfPages;
    }
}