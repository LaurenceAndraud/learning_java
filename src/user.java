import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;
    private final int maxBooksAllowed = 5; 

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= maxBooksAllowed) {
            System.out.println("Vous avez atteint la limite maximale d'emprunt (" + maxBooksAllowed + " livres).");
        } else if (!book.isInStock()) {
            System.out.println("Le livre '" + book.getTitle() + "' n'est pas en stock.");
        } else if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.setStock(false);  
            System.out.println("Vous avez emprunté le livre : " + book.getTitle());
        } else {
            System.out.println("Vous avez déjà emprunté ce livre.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStock(true);  
            System.out.println("Vous avez rendu le livre : " + book.getTitle());
        } else {
            System.out.println("Le livre '" + book.getTitle() + "' n'a pas été emprunté.");
        }
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User{" +
               "name='" + name + '\'' +
               ", borrowedBooks=\n");
        for (Book book : borrowedBooks) {
            sb.append("- ").append(book.getTitle()).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
}
