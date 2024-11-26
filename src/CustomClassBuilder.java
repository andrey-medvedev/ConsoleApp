import java.util.ArrayList;

public class CustomClassBuilder <T extends CustomClass & Comparable<T>>{
    private Builder<T> builder;

    public CustomClassBuilder(Builder<T> builder){
        this.builder = builder;
    }

    public void setBuilder(Builder<T> builder) {
        this.builder = builder;
    }

    public CustomClass buildFromConsole(){
        return this.builder.buildFromConsole();
    }

    public CustomClass buildFromRandom(){
        return this.builder.buildFromRandom();
    }

    public ArrayList<T> buildFromFile(){
        return this.builder.buildFromFile();
    }
}