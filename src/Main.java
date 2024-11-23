import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        enum CustomClassType{BOOK, ROOT_VEGETABLE, AUTOMOBILE};
        CustomClassType customClassType = CustomClassType.BOOK;

        int userChoice;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("""
                    * Для выбора пользовательского класса введите 1 (текущее значение ...);
                    * Для ввода данных с консоли введите 2;
                    * Для ввода данных из файла введите 3;
                    * Для случайной генерации данных введите 4;
                    * Для сортировки данных (с возможностью экспорта результатов) введите 5;
                    * Для поиска элемента в данных (с возможностью экспорта результатов) введите 6;
                    * Для выхода из программы введите 7""");

            userChoice = 0;
            userChoice = in.nextInt();

            if (userChoice == 7){
                break;
            }

            switch (userChoice){
                case 1:
                    //тут просто меняем значение ENUM-a
                    break;
                case 2:
                    //Далее функциональности по списку выше
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }

        }
        in.close();
    }
}