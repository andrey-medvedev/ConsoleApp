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
                    * Введите 1 для выбора пользовательского класса (текущее значение: %s)
                    * Введите 2 для задания количества создаваемых объектов (текущее значение: %d)
                    * Введите 3 для ввода объектов с консоли;
                    * Введите 4 для ввода объектов из файла;
                    * Введите 5 для ввода объектов случайной генерацией;
                    * Введите 6 для сортировки объектов (с возможностью экспорта результатов);
                    * Введите 7 для поиска объекта в данных (с возможностью экспорта результатов);
                    * Введите 8 для просмотра текущих данных
                    * Введите 9 для выхода из программы
                    """, Controller.getCustomClassType().toString(), Controller.getNumberOfObjects());

            userChoice = 0;
            userChoice = in.nextInt();

            if (userChoice == 9){
                break;
            }

            switch (userChoice){
                case 1:
                    System.out.println("Введите новое значение для типа объекта (1 - автомобиль, 2 - книга, 3 - корнеплод)");
                    int internalChoice = in.nextInt();
                    if (internalChoice == 1){
                        Controller.setCustomClassType(CustomClassType.AUTOMOBILE);
                    } else if (internalChoice == 2){
                        Controller.setCustomClassType(CustomClassType.BOOK);
                    } else {
                        Controller.setCustomClassType(CustomClassType.ROOT_VEGETABLE);
                    }
                    break;
                case 2:
                    System.out.println("Введите количество элементов в коллекции");
                    internalChoice = in.nextInt();
                    Controller.setNumberOfObjects(internalChoice);
                    break;
                case 3:
                    Controller.readObjectsFromConsole();
                    break;
                case 4:
                    //должен считывать объекты из файла, тип которых зависит от customClassType (автомобили, корнеплоды, книги)
                    //При вводе объектов необходима валидация
                    //размер массива определяется NumberOfObjects
                    break;
                case 5:
                    Controller.readObjectsFromRandom();
                    break;
                case 6:
                    System.out.println("""
                        * Для сортировки данных по возрастанию (shellSort) введите 1
                        * Для сортировки данных по убыванию (shellSort) введите 2
                        * Для использования альтернативного варианта сортировки введите 3
                """);
                    internalChoice = in.nextInt();
                    Controller.sort(internalChoice);
                    break;
                case 7:
                    Controller.search();
                    break;
                case 8:
                    System.out.println("Текущие данные имеют следующий вид: ");
                    Controller.printData();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
        in.close();
    }
}
