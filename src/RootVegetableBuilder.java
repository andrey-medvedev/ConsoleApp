import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RootVegetableBuilder implements Builder<RootVegetable> {

    public RootVegetable buildFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("Цвет корнеплода:");
        String color = in.nextLine();
        System.out.println("Введите тип корнеплода:");
        String type = in.nextLine();
        System.out.println("Введите вес корнеплода:");
        int weight = in.nextInt();
        return new RootVegetable(color,  type, weight);
    }

    public RootVegetable buildFromRandom(){
        Random rand = new Random();
        String[] types = {"Капустные", "Зонтичные", "Маревые", "Астровые"};
        String type = types[rand.nextInt(types.length)];
        String[] colors = {"Желтый", "Оранжевый", "Красный", "Зеленый", "Розовый", "Коричневый", "Бордовый"};
        String color = colors[rand.nextInt(colors.length)];
        int weight = 1 + (int)(10 * Math.random());
        return new RootVegetable(color, type, weight);
    }

    public ArrayList<RootVegetable> buildFromFile(){

        //при считывании файла валидироть, чтобы в нем было объектов (строк) не менее чем значение Contriller.numberOfObjects
        //Если меньше, то предлагать изменить переменную автоматически (и менять в соответствии с объемом)


        return new ArrayList<RootVegetable>();
    }
}