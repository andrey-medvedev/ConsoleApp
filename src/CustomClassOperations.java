import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomClassOperations {

    private CustomClassOperations(){
    }

    public static <T extends CustomClass & Comparable<T>> void shellSort (ArrayList<T> array, boolean isNotReverseSort){
        int compareCoefficient = isNotReverseSort ? 1 : -1;
        for (int s = array.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < array.size(); ++i){
                for (int j = i - s; j >= 0 && compareCoefficient * (array.get(j).compareTo(array.get(j + s))) > 0; j -= s){
                    Collections.swap(array, j, j + s);
                }
            }
        }
    }

    public static <T extends CustomClass & Comparable<T>> void customSort (ArrayList<T> array, int fieldNumber){
        ArrayList<T> arrayWithEvenValues = new ArrayList<>(array.stream().filter(x -> x.getIntValueForCustomSort() % 2 == 0).toList());
        shellSort(arrayWithEvenValues, true);
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
        shellSort(copyArray, true);
        boolean flag = false;

        int low = 0;
        int high = copyArray.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (copyArray.get(mid).compareTo(object) > 0) {
                high = mid - 1;
            } else if (copyArray.get(mid).compareTo(object) < 0) {

                low = mid + 1;
            } else {
                flag = true;
                break;
            }
        }
        System.out.println("Элемент был " + (!flag ? "не " : "") + "найден в коллекции!");
    }
}

