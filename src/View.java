import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {

        int userChoice;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.printf("""
                    * Для выбора пользовательского класса введите 1 (текущее значение: %s)
                    * Для задания количества создаваемых объектов введите 2 (текущее значение: %d)
                    * Для ввода объектов с консоли введите 3;
                    * Для ввода объектов из файла введите 4;
                    * Для ввода объектов случайной генерацией введите 5;
                    * Для сортировки объектов (с возможностью экспорта результатов) введите 6;
                    * Для поиска объекта в данных (с возможностью экспорта результатов) введите 7;
                    * Для просмотра текущих данных введите 8
                    * Для выхода из программы введите 9
                    """, Controller.getCustomClassType().toString(), Controller.getNumberOfObjects());

            userChoice = 0;
            userChoice = in.nextInt();

            if (userChoice == 9) {
                break;
            }

            switch (userChoice) {
                case 1:
                    System.out.println("Введите новое значение для типа объекта (1 - автомобиль, 2 - книга, 3 - корнеплод)");
                    int internalChoice = in.nextInt();
                    if (internalChoice == 1) {
                        Controller.setCustomClassType(CustomClassType.AUTOMOBILE);
                    } else if (internalChoice == 2) {
                        Controller.setCustomClassType(CustomClassType.BOOK);
                    } else {
                        Controller.setCustomClassType(CustomClassType.ROOT_VEGETABLE);
                    }
                    break;
                case 2:
                    System.out.println("Введите количество элементов в коллекции");
                    internalChoice = in.nextInt();
                    Controller.setNumberOfObjects(internalChoice);
                    break;
                case 3:

                    InputUserGenerator inputHandler = new InputUserGenerator(in);
                    int numObjects = Controller.getNumberOfObjects();
                    CustomClassType type = Controller.getCustomClassType();

                    // Считываем данные
                    List<CustomClass> objects = inputHandler.readObjects(type, numObjects);

                    // Заносим данные
                    switch (type) {
                        case AUTOMOBILE:
                            Controller.automobils.clear();
                            Controller.automobils.addAll((List<Automobile>) (List<?>) objects);
                            break;
                        case BOOK:
                            Controller.books.clear();
                            Controller.books.addAll((List<Book>) (List<?>) objects);
                            break;
                        case ROOT_VEGETABLE:
                            Controller.rootVegetables.clear();
                            Controller.rootVegetables.addAll((List<RootVegetable>) (List<?>) objects);
                            break;
                        default:
                            System.out.println("Неизвестный тип объекта.");
                    }

                    System.out.println("Объекты успешно добавлены.");
                    break;
                case 4:
                    //должен считывать объекты из файла, тип которых зависит от customClassType (автомобили, корнеплоды, книги)
                    //При вводе объектов необходима валидация
                    //размер массива определяется NumberOfObjects
                    break;
                case 5:
                    InputRandomGenerator generator = new InputRandomGenerator();
                    // генерация случайных объектов
                    List<CustomClass> randomObjects = generator.generateRandomObjects(Controller.getCustomClassType(),
                            Controller.getNumberOfObjects());

                    // Проверка и добавление
                    if (Controller.getCustomClassType() == CustomClassType.AUTOMOBILE) {
                        for (CustomClass obj : randomObjects) {
                            if (obj instanceof Automobile) {
                                Controller.automobils.add((Automobile) obj);
                            }
                        }
                    } else if (Controller.getCustomClassType() == CustomClassType.BOOK) {
                        for (CustomClass obj : randomObjects) {
                            if (obj instanceof Book) {
                                Controller.books.add((Book) obj);
                            }
                        }
                    } else if (Controller.getCustomClassType() == CustomClassType.ROOT_VEGETABLE) {
                        for (CustomClass obj : randomObjects) {
                            if (obj instanceof RootVegetable) {
                                Controller.rootVegetables.add((RootVegetable) obj);
                            }
                        }
                    }

                    System.out.println("Случайные объекты добавлены.");
                    break;

                case 6:
                    System.out.println("""
                                    * Для сортировки данных по возрастанию (shellSort) введите 1
                                    * Для сортировки данных по убыванию (shellSort) введите 2
                                    * Для использования альтернативного варианта сортировки введите 3
                            """);
                    internalChoice = in.nextInt();
                    Controller.sort(internalChoice);
                    break;
                case 7:
                    //Должен считывать один объект с консоли (соответственно, сначала должен быть реализован п. 3)
                    //передать в метод ниже считанный объект
                    Controller.search(new Book("", "", 1));
                    break;
                case 8:
                    Controller.printData();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
        in.close();
    }
}
