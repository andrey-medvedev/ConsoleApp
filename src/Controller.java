import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private static CustomClassType customClassType = CustomClassType.AUTOMOBILE;
    private static CustomClassBuilder builder = new CustomClassBuilder(new AutoBuilder());

    private static int numberOfObjects = 5;
    static ArrayList<RootVegetable> rootVegetables = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Automobile> automobils = new ArrayList<>();

    private Controller() {
    }

    public static void readObjectsFromConsole() {
        Controller.clearCustomClassLists();
        for (var i = 0; i < Controller.getNumberOfObjects(); i++) {
            Controller.addCustomClassObject(builder.buildFromConsole());
        }
    }

    public static void readObjectsFromRandom() {
        Controller.clearCustomClassLists();
        for (var i = 0; i < Controller.getNumberOfObjects(); i++) {
            Controller.addCustomClassObject(builder.buildFromRandom());
        }
    }


    public static void search() {
        CustomClass searchObject = builder.buildFromConsole();

        switch (customClassType) {
            case CustomClassType.AUTOMOBILE -> {
                CustomClassOperations.binarySearch(automobils, (Automobile) searchObject);
            }
            case CustomClassType.BOOK -> {
                CustomClassOperations.binarySearch(books, (Book) searchObject);
            }
            case CustomClassType.ROOT_VEGETABLE -> {
                CustomClassOperations.binarySearch(rootVegetables, (RootVegetable) searchObject);
            }
        }

    }

    private static void clearCustomClassLists() {
        Controller.automobils.clear();
        Controller.books.clear();
        Controller.rootVegetables.clear();
    }

    private static void addCustomClassObject(CustomClass object) {
        switch (customClassType) {
            case CustomClassType.AUTOMOBILE -> {
                Controller.automobils.add((Automobile) object);
            }
            case CustomClassType.BOOK -> {
                Controller.books.add((Book) object);
            }
            case CustomClassType.ROOT_VEGETABLE -> {
                Controller.rootVegetables.add((RootVegetable) object);
            }
        }
    }

    public static int getNumberOfObjects() {
        return Controller.numberOfObjects;
    }

    public static void setNumberOfObjects(int numberOfObjects) {
        if (numberOfObjects <= 0) {
            System.out.println("""
                    Значение не может быть <= 0. 
                    Было установлено минимальное возможное значение, равное 1""");
            Controller.numberOfObjects = 1;
        } else {
            Controller.numberOfObjects = numberOfObjects;
        }
    }

    public static CustomClassType getCustomClassType() {
        return Controller.customClassType;
    }

    public static void setCustomClassType(CustomClassType type) {
        Controller.customClassType = type;
        switch (type) {
            case CustomClassType.AUTOMOBILE -> {
                Controller.builder.setBuilder(new AutoBuilder());
            }
            case CustomClassType.BOOK -> {
                Controller.builder.setBuilder(new BookBuilder());
            }
            case CustomClassType.ROOT_VEGETABLE -> {
                Controller.builder.setBuilder(new RootVegetableBuilder());
            }
        }
    }

    public static boolean sort(int mode) {
        switch (mode) {
            case 1:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.shellSort(books, true);
                } else if (Controller.customClassType == CustomClassType.AUTOMOBILE) {
                    CustomClassOperations.shellSort(automobils, true);
                } else {
                    CustomClassOperations.shellSort(rootVegetables, true);
                }
                break;
            case 2:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.shellSort(books, false);
                } else if (Controller.customClassType == CustomClassType.AUTOMOBILE) {
                    CustomClassOperations.shellSort(automobils, false);
                } else {
                    CustomClassOperations.shellSort(rootVegetables, false);
                }
                break;
            case 3:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.customSort(books, 1);
                } else if (Controller.customClassType == CustomClassType.AUTOMOBILE) {
                    CustomClassOperations.customSort(automobils, 1);
                } else {
                    CustomClassOperations.customSort(rootVegetables, 1);
                }
                break;
            case 4:
                System.out.println("""
                        * Вы хотите выгрузить данные?
                        * Для экспорта введите 1
                        * Для отмены введите 2""");

                Scanner in = new Scanner(System.in);
                int exportChoice;
                while (true) {
                    try {
                        exportChoice = in.nextInt();  // Попытка считать число

                        if (exportChoice == 1) {

                            System.out.println("Введите имя файла:");
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

            default:
                System.out.println("В метод передано некорректное значение!");
                return false;
        }
        return true;
    }

    public static void printData() {
        if (Controller.customClassType == CustomClassType.BOOK) {
            for (var book : books) {
                System.out.println(book);
            }
        } else if (Controller.customClassType == CustomClassType.AUTOMOBILE) {
            for (var auto : automobils) {
                System.out.println(auto);
            }
        } else {
            for (var rootVegetable : rootVegetables) {
                System.out.println(rootVegetable);
            }
        }
        System.out.println("\n\n\n");
    }
}
