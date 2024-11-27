import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RootVegetableBuilder implements Builder<RootVegetable> {
    private ArrayList<RootVegetable> objects = new ArrayList<>();

    public RootVegetableBuilder readValuesFromConsole(int number) {
        Scanner in = new Scanner(System.in);
        objects.clear();

        for (int i = 0; i < number; i++) {
            System.out.println("Цвет корнеплода:");
            String color = in.nextLine();
            System.out.println("Введите тип корнеплода:");
            String type = in.nextLine();
            System.out.println("Введите вес корнеплода:");
            int weight = in.nextInt();
            objects.add(new RootVegetable(color, type, weight));
        }
        return this;
    }

    public RootVegetableBuilder readValuesFromRandom(int number){
        Random rand = new Random();
        objects.clear();

        for (int i = 0; i < number; i++) {
            String[] types = {"Капустные", "Зонтичные", "Маревые", "Астровые"};
            String type = types[rand.nextInt(types.length)];
            String[] colors = {"Желтый", "Оранжевый", "Красный", "Зеленый", "Розовый", "Коричневый", "Бордовый"};
            String color = colors[rand.nextInt(colors.length)];
            int weight = 1 + (int) (10 * Math.random());
            objects.add(new RootVegetable(color, type, weight));
        }
        return this;
    }

    public RootVegetableBuilder readValuesFromFile(){
        objects.clear();
        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)
        return this;
    }

    public ArrayList<RootVegetable> build(){
        return objects;
    }
}