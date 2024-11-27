import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoBuilder implements Builder<Automobile> {

    private ArrayList<Automobile> objects = new ArrayList<Automobile>();

    public AutoBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите наименование модели:");
            String model = in.nextLine();
            System.out.println("Введите значение мощности:");
            int power = in.nextInt();
            System.out.println("Введите год производства:");
            int yearOfProduction = in.nextInt();
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

    public AutoBuilder readValuesFromFile(){
        objects.clear();
        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)
        return this;
    }

    public ArrayList<Automobile> build(){
        return objects;
    }
}