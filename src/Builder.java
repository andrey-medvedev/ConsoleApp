import java.util.ArrayList;

interface Builder <T extends CustomClass & Comparable<T>> {
    T buildFromConsole();
    T buildFromRandom();
    ArrayList<T> buildFromFile();
}