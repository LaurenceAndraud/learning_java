import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<Author> authors;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    // Méthode pour ajouter un livre
    public void addBook(Book book) {
        books.add(book);
        book.getAuthor().addBook(book);
    }

    // Méthode pour supprimer un livre
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Méthode pour mettre à jour un livre
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }

    // Méthode pour ajouter un auteur
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Méthode pour supprimer un auteur
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    // Méthode pour mettre à jour un auteur
    public void updateAuthor(Author oldAuthor, Author newAuthor) {
        int index = authors.indexOf(oldAuthor);
        if (index != -1) {
            authors.set(index, newAuthor);
        }
    }

    // Méthode pour emprunter un livre par titre
    public void borrowBook(String title) {
        Optional<Book> book = books.stream()
                                   .filter(b -> b.getTitle().equalsIgnoreCase(title) && b.getStock())
                                   .findFirst();
        if (book.isPresent()) {
            book.get().setStock(false); // Change le statut à non disponible
            System.out.println("Le livre a été emprunté : " + book.get().getTitle());
        } else {
            System.out.println("Le livre n'est pas disponible ou est déjà emprunté.");
        }
    }

    // Méthode pour retourner un livre par titre
    public void returnBook(String title) {
        Optional<Book> book = books.stream()
                                   .filter(b -> b.getTitle().equalsIgnoreCase(title) && !b.getStock())
                                   .findFirst();
        if (book.isPresent()) {
            book.get().setStock(true); // Change le statut à disponible
            System.out.println("Le livre a été retourné : " + book.get().getTitle());
        } else {
            System.out.println("Le livre n'était pas emprunté ou n'existe pas.");
        }
    }

    // Méthode pour rechercher un livre par titre
    public List<Book> searchBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    // Méthode pour rechercher un livre par auteur
    public List<Book> searchBookByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    // Afficher tous les livres
    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
