package Model;

public class Automobile{

    private int power;
    private String model;
    private int yearOfProduction;

    public Automobile(int power, String model, int yearOfProduction){
        this.power = power;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public Automobile(AutoBuilder autoBuilder){
        power = autoBuilder.power;
        model = autoBuilder.model;
        yearOfProduction = autoBuilder.yearOfProduction;
    }

    public int getPower() {
        return this.power;
    }
    public String getModel(){
        return this.model;
    }
    public int getYearOfProduction(){
        return this.yearOfProduction;
    }

    public void setPower(int power){
        this.power = power;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public static class AutoBuilder{
        private int power;
        private String model;
        private int yearOfProduction;

        public AutoBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public AutoBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public AutoBuilder setYearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public Automobile build(){
            return new Automobile(this);
        }
    }
}
