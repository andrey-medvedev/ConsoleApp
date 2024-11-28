import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RootVegetableBuilder implements Builder<RootVegetable> {
    private final ArrayList<RootVegetable> objects = new ArrayList<>();

    public RootVegetableBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            System.out.println("Введите тип корнеплода:");

            String type = UserInputValidator.stringInputWithValidation();

            System.out.println("Цвет корнеплода:");
            String color = UserInputValidator.stringInputWithValidation();

            System.out.println("Введите вес корнеплода:");
            int weight = UserInputValidator.intInputWithValidation();

            objects.add(new RootVegetable(color, type, weight));
        }
        return this;
    }

    public RootVegetableBuilder readValuesFromRandom(int number){
        Random rand = new Random();
        objects.clear();

        for (int i = 0; i < number; i++) {
            String[] types = {"Капустные", "Зонтичные", "Маревые", "Астровые"};
            String type = validateRootVegetableType(types[rand.nextInt(types.length)]);
            String[] colors = {"Желтый", "Оранжевый", "Красный", "Зеленый", "Розовый", "Коричневый", "Бордовый"};
            String color = validateRootVegetableColor(colors[rand.nextInt(colors.length)]);
            int weight = validateRootVegetableWeight(1 + (int) (10 * Math.random()));
            objects.add(new RootVegetable(color, type, weight));
        }
        return this;
    }

    public RootVegetableBuilder readValuesFromFile(String path){
        objects.clear();

        for (var rootVegetable : CustomClassOperations.deserializeArray(path)) {
            validateRootVegetableType(((RootVegetable) rootVegetable).getType());
            validateRootVegetableColor(((RootVegetable) rootVegetable).getColor());
            validateRootVegetableWeight(((RootVegetable) rootVegetable).getWeight());
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

    public static String validateRootVegetableType(String type) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(!type.matches("^[А-Яа-яЁё ]+$")) {
                System.out.println("Тип корнеплода может содержать только кирилицу");
            } else if(!type.matches("(Капустные|Зонтичные|Маревые|Астровые|" +
                    "капустные|зонтичные|маревые|астровые)")) {
                System.out.println("Тип корнеплода не существует");
            } else {
                break;
            }
            System.out.println("Введите корректный тип корнеплода");
            type = scanner.nextLine();
        }
        return type;
    }

    public static String validateRootVegetableColor(String color) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(!color.matches("^[А-Яа-яЁё ]+$")) {
                System.out.println("Цвет корнеплода может содержать только кирилицу");
            } else if(!color.matches("(Желтый|Оранжевый|Красный|Зеленый|Розовый|Коричневый|Бордовый" +
                    "|желтый|оранжевый|красный|зеленый|розовый|коричневый|бордовый)")) {
                System.out.println("Цвет корнеплода не существует");
            } else {
                break;
            }
            System.out.println("Введите корректный цвет корнеплода");
            color = scanner.nextLine();
        }
        return color;
    }

    public static int validateRootVegetableWeight(int weight) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(weight <= 0 || weight > 10) {
                System.out.println("Вес корнеплода должен быть в диапазоне 0 - 10 кг.");
            } else {
                break;
            }
            System.out.println("Введите корректный вес корнеплода");
            weight = scanner.nextInt();
        }
        return weight;
    }
}