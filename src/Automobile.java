import java.io.Serial;
import java.io.Serializable;
public class Automobile extends CustomClass implements Comparable<Automobile>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
    public int getIntValueForCustomSort() {
        return this.power;
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

        compareResult = Integer.compare(this.power, o.getPower());
        if (compareResult != 0){
            return compareResult;
        }

        return Integer.compare(this.yearOfProduction, o.getYearOfProduction());
    }

    @Override
    public String toString(){
        return String.format("This Automobile power = %d, model = '%s',  year of production = %d",this.power, this.model,  this.yearOfProduction);
    }
}
