import java.util.ArrayList;

public class Controller {
    private static CustomClassType customClassType = CustomClassType.AUTOMOBILE;
    private static CustomClassBuilder builder = new CustomClassBuilder(new AutoBuilder());
    private static int numberOfObjects = 5;
    private static ArrayList<RootVegetable> rootVegetables = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Automobile> automobils = new ArrayList<>();

    private Controller(){
    }

    public static void readObjectsFromConsole(){
        Controller.clearCustomClassLists();
        for(var object : builder.buildFromConsole(Controller.getNumberOfObjects())){
            Controller.addCustomClassObject((CustomClass) object);
        }
    }

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

    public static boolean sort(int mode){
        switch (mode){
            case 1:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.shellSort(books, true);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.shellSort(automobils, true);
                } else{
                    CustomClassOperations.shellSort(rootVegetables, true);
                }
                break;
            case 2:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.shellSort(books, false);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.shellSort(automobils, false);
                } else{
                    CustomClassOperations.shellSort(rootVegetables, false);
                }
                break;
            case 3:
                if (Controller.customClassType == CustomClassType.BOOK) {
                    CustomClassOperations.customSort(books, 1);
                } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
                    CustomClassOperations.customSort(automobils, 1);
                } else{
                    CustomClassOperations.customSort(rootVegetables, 1);
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
}
