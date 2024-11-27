import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RootVegetableBuilder implements Builder<RootVegetable> {
    private final ArrayList<RootVegetable> objects = new ArrayList<>();

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

    public RootVegetableBuilder readValuesFromFile(String path){
        objects.clear();

        for (var rootVegetable : CustomClassOperations.deserializeArray(path)) {
            objects.add((RootVegetable) rootVegetable);
        }

        if (objects.size() != Controller.getNumberOfObjects()){
            System.out.println("""
        Количество объектов в файле отлично от установленного в программе.
        Значение в настройках программы было обновлено!""");
            Controller.setNumberOfObjects(objects.size());
        }

        return this;
    }

    public ArrayList<RootVegetable> build(){
        return objects;
    }
}