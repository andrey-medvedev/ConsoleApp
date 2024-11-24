import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomClassOperations {

    private CustomClassOperations(){
    }

    //Код ShellSorta, сам алгоритм нужно разобрать дополнительно
    public static <T extends CustomClass & Comparable<T>> void shellSort (ArrayList<T> array){
        for (int s = array.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < array.size(); ++i){
                for (int j = i - s; j >= 0 && array.get(j).compareTo(array.get(j + s)) > 0; j -= s){
                    Collections.swap(array, j, j + s);
                }
            }
        }
    }

    public static <T extends CustomClass & Comparable<T>> int binarySearch (ArrayList<T> array, T object){
        shellSort(array);
        int low = 0;
        int high = array.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array.get(mid).compareTo(object) > 0) {
                high = mid - 1;
            } else if (array.get(mid).compareTo(object) < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

