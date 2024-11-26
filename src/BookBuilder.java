import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class BookBuilder implements Builder<Book> {

    public Book buildFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя автора:");
        String author = in.nextLine();
        System.out.println("Введите наименование книги:");
        String name = in.nextLine();
        System.out.println("Введите количество страниц:");
        int numberOfPages = in.nextInt();
        return new Book(author, name, numberOfPages);
    }

    public Book buildFromRandom(){
        Random rand = new Random();

        Object[][] books = {{"Достоевский Ф.М.", "Преступление и наказание",  465},
                {"Пушкин А.С.", "Капитанская дочка", 348},
                {"Лермонтов Р.М.", "герой нашего времени", 183},
                {"Карамзин Н.М.", "Бедная Лиза", 279},
                {"Салтыков-Щедрин М.Е.", "Дикий помещик", 286}};

        Object[] book = books[rand.nextInt(books.length)];
        String author = (String) book[0];
        String name = (String) book[1];
        int numberOfPages = (int) book[2];

        return new Book(author, name, numberOfPages);
    }

    public ArrayList<Book> buildFromFile(){

        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)

        return new ArrayList<Book>();
    }
}