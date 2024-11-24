public class Book extends CustomClass implements Comparable<Book>{
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
        return String.format("This Book author = '%s', name = '%s', number of pages = %d", this.author, this.name, this.numberOfPages);
    }
}
