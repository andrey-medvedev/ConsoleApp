import java.util.ArrayList;
import java.util.Map;
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
        Map<String[], Integer> books = Map.of(new String[] {"Достоевский Ф.М.", "Преступление и наказание"}, 465, new String[] {"Пушкин А.С.", "Капитанская дочка"}, 348 , new String[] {"Лермонтов Р.М.", "герой нашего времени"}, 183, new String[] {"Карамзин Н.М.", "Бедная Лиза"}, 279, new String[] {"Салтыков-Щедрин М.Е.", "Дикий помещик"}, 286);
        Map.Entry<String[], Integer> entry = books.entrySet().stream().findAny().orElse(null);
        String author = entry.getKey()[0];
        String name = entry.getKey()[1];
        int numberOfPages = entry.getValue();
        return new Book(author, name, numberOfPages);
    }

    public ArrayList<Book> buildFromFile(){

        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)

        return new ArrayList<Book>();
    }
}