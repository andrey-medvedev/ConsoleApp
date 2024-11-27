import java.util.ArrayList;
import java.util.Comparator;

public interface Sort {
    <T extends CustomClass & Comparable<T>> void sort(ArrayList<T> array, boolean isNotReverseSort, Comparator<T> comparator);
}
