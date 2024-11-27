import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomClassOperations {

    private CustomClassOperations(){
    }

    public static <T extends CustomClass & Comparable<T>> void shellSort (ArrayList<T> array, boolean isNotReverseSort, Comparator<T> comparator){
        int compareCoefficient = isNotReverseSort ? 1 : -1;
        if (comparator == null){
            comparator = T::compareTo;
        }

        for (int s = array.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < array.size(); ++i){
                for (int j = i - s; j >= 0 && compareCoefficient * comparator.compare(array.get(j), array.get(j + s)) > 0; j -= s){
                    Collections.swap(array, j, j + s);
                }
            }
        }
    }

    public static <T extends CustomClass & Comparable<T>> void customSort (ArrayList<T> array){
        ArrayList<T> arrayWithEvenValues = new ArrayList<>(array.stream().filter(x -> x.getIntValueForCustomSort() % 2 == 0).toList());
        Comparator<T> customComparator = Comparator.comparing(T::getIntValueForCustomSort);
        shellSort(arrayWithEvenValues, true, customComparator);
        int j = 0;
        for(int i = 0; i < array.size(); i++){
            if (array.get(i).getIntValueForCustomSort() % 2 == 0){
                array.set(i, arrayWithEvenValues.get(j));
                j++;
            }
        }
    }

    public static <T extends CustomClass & Comparable<T>> void binarySearch (ArrayList<T> array, T object){
        ArrayList<T> copyArray = new ArrayList<>(array);
        shellSort(copyArray, true, null);
        boolean flag = false;

        int lower = 0;
        int high = copyArray.size() - 1;
        while (lower <= high) {
            int middle = (lower + high) / 2;

            if (copyArray.get(middle).compareTo(object) > 0) {
                high = middle - 1;
            } else if (copyArray.get(middle).compareTo(object) < 0) {

                lower = middle + 1;
            } else {
                flag = true;
                break;
            }
        }
        System.out.println("Элемент " + (!flag ? "не " : "") + "был найден в коллекции!");
    }

    public static <T extends CustomClass & Serializable> void serializeArray (ArrayList<T> array, String path){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends CustomClass & Serializable> ArrayList<T> deserializeArray (String path){
        ArrayList<T> deserializedArray = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            deserializedArray = (ArrayList<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedArray;
    }
}

