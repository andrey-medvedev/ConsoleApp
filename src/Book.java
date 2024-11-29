import java.io.Serial;
import java.io.Serializable;
public class Book implements CustomObject, Comparable<Book>, Serializable, CsvConvertable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String author;
    private String name;
    private int numberOfPages;

    public Book (String author, String name, int numberOfPages){
        this.author = author;
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return this.name;
    }
    public int getNumberOfPages() {
        return this.numberOfPages;
    }
    public String getAuthor() {
        return this.author;
    }
    public int getIntValueForCustomSort(){
        return this.numberOfPages;
    }

    public void setAuthors(String author) {
        this.author = author;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public int compareTo(Book o){
        int compareResult = this.author.compareTo(o.getAuthor());
        if (compareResult != 0){
            return compareResult;
        }

        compareResult = this.name.compareTo(o.getName());
        if (compareResult != 0){
            return compareResult;
        }

        return Integer.compare(this.numberOfPages, o.getNumberOfPages());
    }

    @Override
    public String toString(){
        return String.format("Автор = '%s', Название книги = '%s', Количество страниц = %d",
                this.author, this.name, this.numberOfPages);
    }

    public String toCSV() {
        return author + "," + name + "," + numberOfPages;
    }

    @Override
    public String getCSVHeaders() {
        return "Автор, Название книги, Количество страниц";
    }

    @Override
    public void fromCSV(String[] fields) {
        if (fields.length == 3) {
            this.author = fields[0];
            this.name = fields[1];
            this.numberOfPages = Integer.parseInt(fields[2]);
        }

    }
}