import java.util.InputMismatchException;
import java.util.Scanner;

public class ExportHandler {
    public static void handleExport() {

        System.out.println("""
                * Вы хотите выгрузить данные?
                * Для экспорта введите 1
                * Для отмены введите 2""");

        Scanner in = new Scanner(System.in);
        int exportChoice;
        while (true) {
            try {
                exportChoice = in.nextInt();

                if (exportChoice == 1) {
                    System.out.println("Введите имя файла (без ковычек):");
                    String fileName = in.next();
                    fileName = fileName + ".csv";

                    switch (Controller.getCustomClassType()) {
                        case AUTOMOBILE:
                            OutputCsv.exportToCSV(Controller.automobils, fileName);
                            break;
                        case BOOK:
                            OutputCsv.exportToCSV(Controller.books, fileName);
                            break;
                        case ROOT_VEGETABLE:
                            OutputCsv.exportToCSV(Controller.rootVegetables, fileName);
                            break;
                    }
                    break;
                } else if (exportChoice == 2) {
                    System.out.println("Экспорт отменен.");
                    break;
                } else {
                    System.out.println("Ошибка ввода, повторите попытку:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите 1 или 2.");
                in.nextLine();
            }
        }
    }
}
