public class RootVegetable extends CustomClass implements Comparable<RootVegetable>{
    private String Color;
    private String type;
    private int weight;

    public RootVegetable(String color, String type, int weight){
        this.Color = color;
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return Color;
    }
    public String getType() {
        return type;
    }

    public void setColor(String color) {
        Color = color;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    @Override
    public int compareTo(RootVegetable o){
        return Integer.compare(this.weight, o.getWeight());
    }
}
