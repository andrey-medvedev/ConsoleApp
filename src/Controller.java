import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static CustomClassType customClassType = CustomClassType.AUTOMOBILE;
    private static CustomClassBuilder builder = new CustomClassBuilder(new AutoBuilder());
    private static int numberOfObjects = 5;
    static ArrayList<RootVegetable> rootVegetables = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Automobile> automobils = new ArrayList<>();
    private static String filePath;

    private Controller(){
    }

    public static void readObjectsFromConsole(){
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromConsole(Controller.getNumberOfObjects())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }
    public static void readObjectsFromFile() {
        System.out.println("Введите путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        filePath = scanner.next();
        if (filePath == null || filePath.isBlank()) {
            System.out.println("Путь к файлу не задан.");
            return;
        }

        Controller.clearCustomClassLists();

        try {
            Class<?> clazz;
            switch (Controller.getCustomClassType()) {
                case AUTOMOBILE:
                    clazz = Automobile.class;
                    break;
                case BOOK:
                    clazz = Book.class;
                    break;
                case ROOT_VEGETABLE:
                    clazz = RootVegetable.class;
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип данных: " + Controller.getCustomClassType());
            }

            List<?> importedObjects = InputCsv.importFromCSV(filePath, clazz);

            if (importedObjects.isEmpty()) {
                return;
            }

            for (var object : importedObjects) {
                Controller.addCustomClassObject((CustomClass) object);
            }
            System.out.println("Данные успешно импортированы из файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
        } catch (ClassCastException e) {
            System.out.println("Ошибка преобразования типов: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

//    public static void readObjectsFromFile(){
//        Controller.clearCustomClassLists();
//        for(var object : builder.buildFromFile(Controller.filePath)){
//            Controller.addCustomClassObject((CustomClass) object);
//        }
//    }

    public static void readObjectsFromRandom(){
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromRandom(Controller.getNumberOfObjects())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }

    public static void search(){
        CustomClass searchObject = (CustomClass) (Controller.builder.buildFromConsole(1).getFirst());

        switch (customClassType){
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

    private static void clearCustomClassLists(){
            Controller.automobils.clear();
            Controller.books.clear();
            Controller.rootVegetables.clear();
    }

    private static void addCustomClassObject(CustomClass object){
        switch (customClassType){
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

    public static void saveDataToFile(){
        switch (customClassType){
            case CustomClassType.AUTOMOBILE -> {
                CustomClassOperations.serializeArray(Controller.automobils, Controller.filePath);
            }
            case CustomClassType.BOOK -> {
                CustomClassOperations.serializeArray(Controller.books, Controller.filePath);
            }
            case CustomClassType.ROOT_VEGETABLE -> {
                CustomClassOperations.serializeArray(Controller.rootVegetables, Controller.filePath);
            }
        }
    }

    public static boolean sort(int mode){
        switch (mode){
            case 1:
                CustomClassOperations.setSort(ShellSort.getInstance());
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.getSort().sort(books, true, null);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.getSort().sort(automobils, true, null);
                } else{
                    CustomClassOperations.getSort().sort(rootVegetables, true, null);
                }
                break;
            case 2:
                CustomClassOperations.setSort(ShellSort.getInstance());
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.getSort().sort(books, false, null);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.getSort().sort(automobils, false, null);
                } else{
                    CustomClassOperations.getSort().sort(rootVegetables, false, null);
                }
                break;
            case 3:
                CustomClassOperations.setSort(CustomSort.getInstance());
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.getSort().sort(books, false, null);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.getSort().sort(automobils, false, null);
                } else{
                    CustomClassOperations.getSort().sort(rootVegetables, false, null);
                }
                break;
            default:
                System.out.println("В метод передано некорректное значение!");
                return false;
        }
        return true;
    }

    public static void printData(){
        if (Controller.customClassType == CustomClassType.BOOK) {
            for (var book : books){
                System.out.println(book);
            }
        } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
            for (var auto : automobils){
                System.out.println(auto);
            }
        } else{
            for (var rootVegetable : rootVegetables){
                System.out.println(rootVegetable);
            }
        }
        System.out.println("\n\n\n");
    }

    public static int getNumberOfObjects(){
        return Controller.numberOfObjects;
    }

    public static void setNumberOfObjects (int numberOfObjects)  {
        if (numberOfObjects <= 0){
            System.out.println("""
        Значение не может быть <= 0. 
        Было установлено минимальное возможное значение, равное 1""");
            Controller.numberOfObjects = 1;
        } else {
            Controller.numberOfObjects = numberOfObjects;
        }
    }

    public static CustomClassType getCustomClassType(){
        return Controller.customClassType;
    }

    public static void setCustomClassType(CustomClassType type){
        Controller.customClassType = type;
        switch (type){
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
}
