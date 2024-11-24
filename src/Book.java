public class Book extends CustomClass implements Comparable<Book>{
    private String[] authors;
    private String name;
    private int numberOfPages;

    public Book (String[] authors, String name, int numberOfPages){
        this.authors = authors;
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public int compareTo(Book o){
        return Integer.compare(this.numberOfPages, o.getNumberOfPages());
    }

}
