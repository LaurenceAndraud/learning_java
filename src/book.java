public class Book {
    String title;
    String author;
    String editor;
    int numberPages;
    String genre;
    double price;
    boolean inStock;

    public Book(String title, String author, String editor, int numberPages, String genre, double price, boolean inStock){
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.numberPages = numberPages;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }

    public String getTitle() {
        return title; 
    }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) { this.author = author; }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) { this.editor = editor; }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) { this.numberPages = numberPages; }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) { this.genre = genre; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public boolean getStock() {
        return inStock;
    }

    public void setStock(boolean inStock) { this.inStock = inStock; }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", editor='" + editor + '\'' +
               ", numberPages=" + numberPages +
               ", genre='" + genre + '\'' +
               ", price=" + price +
               ", inStock=" + inStock +
               '}';
    }
}
