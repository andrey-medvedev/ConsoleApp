package Model;

public class RootVegetable {

    private String color;
    private String type;
    private double weight;

    public RootVegetable(String color, String type, double weight){
        this.color = color;
        this.type = type;
        this.weight = weight;
    }

    public RootVegetable(RootVegetableBuilder rootVegetableBuilder){
        color = rootVegetableBuilder.color;
        type = rootVegetableBuilder.type;
        weight = rootVegetableBuilder.weight;
    }

    public double getWeight() {
        return this.weight;
    }
    public String getColor() {
        return this.color;
    }
    public String getType() {
        return this.type;
    }



    public void setColor(String color) {
        this.color = color;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public static class RootVegetableBuilder{
        private String color;
        private String type;
        private double weight;

        public RootVegetableBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootVegetableBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootVegetableBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetable build(){
            new RootVegetable(this);
        }
    }

}
