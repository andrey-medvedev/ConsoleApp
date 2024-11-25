import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller <T extends CustomClass & Comparable<T>> {
    private static CustomClassType customClassType = CustomClassType.AUTOMOBILE;
    private static int numberOfObjects = 5;

    public static void setNumberOfObjects (int numberOfObjects) throws IllegalArgumentException {
        if (numberOfObjects <= 0){
            throw new IllegalArgumentException("Передано некорректное значение");
        } else {
            Controller.numberOfObjects = numberOfObjects;
        }
    }

    public static int getNumberOfObjects(){
        return Controller.numberOfObjects;
    }

    public static CustomClassType getCustomClassType(){
        return Controller.customClassType;
    }

    public static ArrayList<RootVegetable> rootVegetables = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();

    //пока поиграемся с ручными данными
    public static ArrayList<Automobile> automobils = new ArrayList<>(List.of(new Automobile(400, "BMW", 1990),
            new Automobile(400, "BMW", 1991),
            new Automobile(410, "Mercedes", 1995),
            new Automobile(390, "Opel", 1996),
            new Automobile(500, "BMW", 1992),
            new Automobile(350, "BMW", 1991),
            new Automobile(310, "Mercedes", 1992),
            new Automobile(405, "Opel", 1996)));


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
                System.out.println("Некорректный ввод");
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

    public static <T extends CustomClass & Comparable<T>> void search(T object){
        int objectIndex = 0;
        if (Controller.customClassType == CustomClassType.BOOK) {
            objectIndex = CustomClassOperations.binarySearchIndex(books,  (Book)object);
        } else if(Controller.customClassType == CustomClassType.AUTOMOBILE){
            objectIndex = CustomClassOperations.binarySearchIndex(automobils,  (Automobile)object);
        } else {
            objectIndex = CustomClassOperations.binarySearchIndex(rootVegetables,  (RootVegetable)object);
        }
        if (objectIndex != -1){
            System.out.printf("Элемент найден в коллекции. Его индекс: %d", objectIndex);
        }
    }

    public static void setCustomClassType(CustomClassType type){
        Controller.customClassType = type;
    }
}
