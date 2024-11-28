import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShellSort implements Sorter {
    private static ShellSort instance = new ShellSort();

    private ShellSort(){
    }

    public static ShellSort getInstance(){
        return instance;
    }

    @Override
    public <T extends CustomObject & Comparable<T>> void sort(ArrayList<T> array, boolean isNotReverseSort) {
        this.sort(array, isNotReverseSort, null);
    }
    @Override
    public <T extends CustomObject & Comparable<T>> void sort(ArrayList<T> array, boolean isNotReverseSort, Comparator<T> comparator) {
        int compareCoefficient = isNotReverseSort ? 1 : -1;

        if (comparator == null) {
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
}
