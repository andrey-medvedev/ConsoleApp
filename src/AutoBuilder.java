import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoBuilder implements Builder<Automobile> {

    public Automobile buildFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите наименование модели:");
        String model = in.nextLine();
        System.out.println("Введите значение мощности:");
        int power = in.nextInt();
        System.out.println("Введите год производства:");
        int yearOfProduction = in.nextInt();

        return new Automobile(power, model, yearOfProduction);
    }

    public Automobile buildFromRandom(){
        Random rand = new Random();
        int power = 250 + (int)(100 * Math.random());
        String[] models = {"opel", "BMW", "Mercedes", "Mitsubishi", "Audi"};
        String model = models[rand.nextInt(models.length)];
        int yearOfProduction = 1990 + (int)(30 * Math.random());
        return new Automobile(power, model, yearOfProduction);
    }

    public ArrayList<Automobile> buildFromFile(){

        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)

        return new ArrayList<Automobile>();
    }
}