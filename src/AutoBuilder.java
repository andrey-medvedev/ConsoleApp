import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoBuilder implements Builder<Automobile> {

    private final ArrayList<Automobile> objects = new ArrayList<Automobile>();

    public AutoBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите наименование модели:");
            String model = in.nextLine();
            System.out.println("Введите значение мощности:");
            int power = Integer.parseInt(in.nextLine());
            System.out.println("Введите год производства:");
            int yearOfProduction = Integer.parseInt(in.nextLine());
            objects.add(new Automobile(power, model, yearOfProduction));
        }
        return this;
    }

    public AutoBuilder readValuesFromRandom(int number){
        Random rand = new Random();
        objects.clear();

        for (int i = 0; i < number; i++) {
            int power = 250 + (int) (100 * Math.random());
            String[] models = {"opel", "BMW", "Mercedes", "Mitsubishi", "Audi"};
            String model = models[rand.nextInt(models.length)];
            int yearOfProduction = 1990 + (int) (30 * Math.random());
            objects.add(new Automobile(power, model, yearOfProduction));
        }
        return this;
    }

    public AutoBuilder readValuesFromFile(String path){
        objects.clear();

        for (var auto : CustomClassOperations.deserializeArray(path)) {
            objects.add((Automobile) auto);
        }

        if (objects.size() != Controller.getNumberOfObjects()){
            System.out.println("""
        Количество объектов в файле отлично от установленного в программе.
        Значение в настройках программы было обновлено!""");
            Controller.setNumberOfObjects(objects.size());
        }

        return this;
    }

    public ArrayList<Automobile> build(){
        return objects;
    }
}