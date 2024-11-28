import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoBuilder implements Builder<Automobile> {

    private final ArrayList<Automobile> objects = new ArrayList<Automobile>();

    public AutoBuilder readValuesFromConsole(int number) {
        objects.clear();

        for (int i = 0; i < number; i++) {
            System.out.println("Введите наименование модели:");

            String model = UserInputValidator.stringInputWithValidation();
            System.out.println("Введите значение мощности:");
            int power = UserInputValidator.intInputWithValidation();
            System.out.println("Введите год производства:");
            int yearOfProduction = UserInputValidator.intInputWithValidation();

            objects.add(new Automobile(power, model, yearOfProduction));
        }
        return this;
    }

    public AutoBuilder readValuesFromRandom(int number){
        Random rand = new Random();
        objects.clear();

        for (int i = 0; i < number; i++) {
            int power = validateCarPower(250 + (int) (100 * Math.random()));
            String[] models = {"opel", "BMW", "Mercedes", "Mitsubishi", "Audi"};
            String model = validateCarModel(models[rand.nextInt(models.length)]);
            int yearOfProduction = validateCarYearOfProduction(1990 + (int) (30 * Math.random()));
            objects.add(new Automobile(power, model, yearOfProduction));
        }
        return this;
    }

    public AutoBuilder readValuesFromFile(String path){
        objects.clear();

        for (var auto : CustomClassOperations.deserializeArray(path)) {
            validateCarModel(((Automobile) auto).getModel());
            validateCarPower(((Automobile) auto).getPower());
            validateCarYearOfProduction(((Automobile) auto).getYearOfProduction());
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

    public static int validateCarPower(int power) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(power < 150 || power > 350) {
                System.out.println("Мощность машины должна находиться в диапозоне 150 - 350 л.с.");
            } else {
                break;
            }
            System.out.println("Введите корректное значение мощности машины");
            power = scanner.nextInt();
        }
        return power;
    }

    public static String validateCarModel(String model) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(model.length() < 3 || model.length() > 10) {
                System.out.println("Длина названия модели автомобиля должна быть от 3 до 10 символов");
            } else if(!model.matches("^[a-zA-Z]+$")) {
                System.out.println("Название модели автомобиля может содержать только латинские буквы");
            } else if(!model.matches("(?i)^(opel|BMW|Mercedes|Mitsubishi|Audi)$")) {
                System.out.println("Название модели не существует");
            } else {
                break;
            }
            System.out.println("Введите корректное название модели");
            model = scanner.nextLine();
        }
        return model;
    }

    public static int validateCarYearOfProduction(int yearOfProduction) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(yearOfProduction < 1990 || yearOfProduction > 2020) {
                System.out.println("Значение года производства автомобиля должен находиться в диапазоне 1990 - 2020 г.");
            } else {
                break;
            }
            System.out.println("Введи корректное значение года производства");
            yearOfProduction = scanner.nextInt();
        }
        return yearOfProduction;
    }
}