public class Automobile extends CustomClass implements Comparable<Automobile>, Cloneable {
    private int power;
    private String model;
    private int yearOfProduction;

    public Automobile(int power, String model, int yearOfProduction){
        this.power = power;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
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

    @Override
    public int compareTo(Automobile o){

        int compareResult = this.model.compareTo(o.getModel());
        if (compareResult != 0){
            return compareResult;
        }

        compareResult = Integer.compare(this.yearOfProduction, o.getYearOfProduction());
        if (compareResult != 0){
            return compareResult;
        }

        return Integer.compare(this.power, o.getPower());
    }

    @Override
    public String toString(){
        return String.format("This Automobile model = '%s', power = %d, year of production = %d", this.model, this.power, this.yearOfProduction);
    }

    @Override
    public Automobile clone() throws CloneNotSupportedException {
        return (Automobile) super.clone();
    }
}
