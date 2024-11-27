import java.util.ArrayList;

interface Builder <T extends CustomClass & Comparable<T>> {

    Builder<T> readValuesFromConsole(int number);
    Builder<T> readValuesFromRandom(int number);
    Builder<T> readValuesFromFile(String path);

    ArrayList<T> build();
}