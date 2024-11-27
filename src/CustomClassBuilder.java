import java.util.ArrayList;

public class CustomClassBuilder <T extends CustomClass & Comparable<T>>{
    private Builder<T> builder;

    public CustomClassBuilder(Builder<T> builder){
        this.builder = builder;
    }

    public void setBuilder(Builder<T> builder) {
        this.builder = builder;
    }

    public ArrayList<T> buildFromConsole(int number){
        return this.builder.readValuesFromConsole(number).build();
    }

    public ArrayList<T> buildFromRandom(int number){
        return this.builder.readValuesFromRandom(number).build();
    }

    public ArrayList<T> buildFromFile(){
        return this.builder.readValuesFromFile().build();
    }
}