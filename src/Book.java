public class Book {

    private String bookTitle;
    private String author;
    private String description;
    private double price;
    private boolean inStock;

    public Book(){

    }

    public Book(String bookTitle, String author, String description, double price, boolean inStock) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }
    public String getDisplayText(){
        return "Author: " + author + "\nTitle: " + bookTitle + "\nDescription: " + description;
    }
    public String getBookTitle(){
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
