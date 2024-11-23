public class Automobile extends CustomClass implements Comparable<Automobile> {
    private int power;
    private String model;
    private int yearOfProduction;

    public Automobile(int power, String model, int yearOfProduction){
        this.power = power;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public int getPower() {
        return power;
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

    @Override
    public int compareTo(Automobile o){
        return Integer.compare(this.power, o.getPower());
    }
}
