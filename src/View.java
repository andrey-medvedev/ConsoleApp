import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class View {
    public static void main(String[] args) {

        int userChoice;
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.printf("""
                    * Для выбора пользовательского класса введите 1 (текущее значение: %s)
                    * Для задания количества создаваемых объектов введите 2 (текущее значение: %d)
                    * Для ввода объектов с консоли введите 3;
                    * Для ввода объектов из файла введите 4;
                    * Для ввода объектов случайной генерацией введите 5;
                    * Для сортировки объектов (с возможностью экспорта результатов) введите 6;
                    * Для поиска объекта в данных (с возможностью экспорта результатов) введите 7;
                    * Для просмотра текущих данных введите 8
                    * Для выхода из программы введите 9
                    """, Controller.customClassType.toString(), Controller.numberOfObjects);

            userChoice = 0;
            userChoice = in.nextInt();

            if (userChoice == 9){
                break;
            }

            switch (userChoice){
                case 1:
                    //тут просто меняем значение ENUM-a
                    break;
                case 2:
                    //тут просто меняем значение numberOfObjects
                    //при передаче значения < 0 кидаем исключение в контроллере
                    break;
                case 3:
                    //должен очищать массив userObjects и заполнять его новыми объектами, тип которых зависит от customClassType (автомобили, корнеплоды, книги)
                    //При вводе объектов необходима валидация
                    //размер массива определяется NumberOfObjects
                    break;
                case 4:
                    //должен очищать массив userObjects и заполнять его новыми объектами, тип которых зависит от customClassType (автомобили, корнеплоды, книги)
                    //При вводе объектов необходима валидация
                    //размер массива определяется NumberOfObjects
                    break;
                case 5:
                    //должен очищать массив userObjects и заполнять его новыми объектами, тип которых зависит от customClassType (автомобили, корнеплоды, книги)
                    //При вводе объектов необходима валидация
                    //размер массива определяется NumberOfObjects
                    break;
                case 6:
                    System.out.println("""
                        * Для сортировки данных по возрастанию (shellSort) введите 1
                        * Для сортировки данных по убыванию (shellSort) введите 2
                        * Для использования альтернативного варианта сортировки введите 3
                """);
                    var mode = in.nextInt();
                    Controller.sort(mode);
                    break;
                case 7:
                    break;
                case 8:
                    Controller.printData();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
        in.close();
    }
}
