import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); 
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        boolean exists = books.stream()
                              .anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle()));
        if (!exists) {
            books.add(book);
        } else {
            System.out.println("Le livre existe déjà pour cet auteur.");
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Author: " + name + "\nBooks:\n");
        for (Book book : books) {
            sb.append("- ").append(book.getTitle()).append("\n");
        }
        return sb.toString();
    }
}
