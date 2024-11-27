import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class BookBuilder implements Builder<Book> {

    private ArrayList<Book> objects = new ArrayList<>();

    public BookBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя автора:");
            String author = in.nextLine();
            System.out.println("Введите наименование книги:");
            String name = in.nextLine();
            System.out.println("Введите количество страниц:");
            int numberOfPages = in.nextInt();
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
            String author = (String) book[0];
            String name = (String) book[1];
            int numberOfPages = (int) book[2];
            objects.add(new Book(author, name, numberOfPages));
        }
        return this;
    }

    public BookBuilder readValuesFromFile(){
        objects.clear();
        //при считывании файла валидировать, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)
        return this;
    }

    public ArrayList<Book> build(){
        return objects;
    }
}