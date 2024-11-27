import java.io.Serial;
import java.io.Serializable;

public class RootVegetable extends CustomClass implements Comparable<RootVegetable>, Serializable, CsvConvertable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String color;
    private String type;
    private int weight;

    public RootVegetable(String color, String type, int weight) {
        this.color = color;
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public String getType() {
        return this.type;
    }

    public int getIntValueForCustomSort() {
        return this.weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(RootVegetable o) {
        int compareResult = this.type.compareTo(o.getType());
        if (compareResult != 0) {
            return compareResult;
        }

        compareResult = this.color.compareTo(o.getColor());
        if (compareResult != 0) {
            return compareResult;
        }

        return Integer.compare(this.weight, o.getWeight());
    }

    @Override
    public String toString() {
        return String.format("Корнеплод типа  = '%s', цвет = '%s', вес (в граммах) = %d",
                this.type, this.color, this.weight);
    }

    @Override
    public String toCSV() {
        return color + "," + type + "," + weight;
    }

    @Override
    public String getCSVHeaders() {
        return "Цвет ,Тип корнеплода , Вес (в граммах)";
    }

    @Override
    public void fromCSV(String[] fields) {
        {
            if (fields.length == 3) {
                this.color = fields[0];
                this.type = fields[1];
                this.weight = Integer.parseInt(fields[2]);
            }
        }


    }
}
