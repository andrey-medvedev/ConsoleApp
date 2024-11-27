package Model;

public class Book {

    private String author;
    private String name;
    private int numberOfPages;

    public Book (String author, String name, int numberOfPages){
        this.author = author;
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public Book (BookBuilder bookBuilder){
        author = bookBuilder.author;
        name = bookBuilder.name;
        numberOfPages = bookBuilder.numberOfPages;
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

    public static class BookBuilder{
        private String author;
        private String name;
        private int numberOfPages;

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setNumberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

}