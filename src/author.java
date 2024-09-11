import java.utils.ArrayList;
import java.util.List;

public class Author {
    String Name;
    List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author: " + name;
    }
}