import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<User> users; 

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.users = new ArrayList<>(); 
    }

    public void addBook(Book book) {
        books.add(book);
        Author author = findAuthorByName(book.getAuthor());
        if (author != null) {
            author.addBook(book);
        } else {
            Author newAuthor = new Author(book.getAuthor());
            newAuthor.addBook(book);
            addAuthor(newAuthor);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
        Author author = findAuthorByName(book.getAuthor());
        if (author != null) {
            author.getBooks().remove(book);
        }
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            Author author = findAuthorByName(oldBook.getAuthor());
            if (author != null) {
                author.getBooks().remove(oldBook);
                author.addBook(newBook);
            }
        }
    }

    public void addAuthor(Author author) {
        if (findAuthorByName(author.getName()) == null) {
            authors.add(author);
        } else {
            System.out.println("L'auteur existe déjà.");
        }
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public void updateAuthor(Author oldAuthor, Author newAuthor) {
        int index = authors.indexOf(oldAuthor);
        if (index != -1) {
            authors.set(index, newAuthor);
        }
    }

    public void borrowBook(String title, User user) {
        Optional<Book> book = books.stream()
                                   .filter(b -> b.getTitle().equalsIgnoreCase(title) && b.isInStock())
                                   .findFirst();
        if (book.isPresent()) {
            book.get().setStock(false); 
            user.borrowBook(book.get());
            System.out.println("Le livre a été emprunté : " + book.get().getTitle());
        } else {
            System.out.println("Le livre n'est pas disponible ou est déjà emprunté.");
        }
    }

    public void returnBook(String title, User user) {
        Optional<Book> book = user.getBorrowedBooks().stream()
                                  .filter(b -> b.getTitle().equalsIgnoreCase(title))
                                  .findFirst();
        if (book.isPresent()) {
            book.get().setStock(true);
            user.returnBook(book.get());
            System.out.println("Le livre a été retourné : " + book.get().getTitle());
        } else {
            System.out.println("Le livre n'était pas emprunté par cet utilisateur ou n'existe pas.");
        }
    }

    public List<Book> searchBookByTitle(String title) {
        return books.stream()
                    .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .toList();
    }

    public List<Book> searchBookByAuthor(String authorName) {
        return books.stream()
                    .filter(b -> b.getAuthor().toLowerCase().contains(authorName.toLowerCase()))
                    .toList();
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("Aucun livre disponible dans la bibliothèque.");
        } else {
            System.out.println("Liste des livres dans la bibliothèque :");
            int i = 1;
            for (Book book : books) {
                System.out.println(i++ + ". " + book.getTitle() + " par " + book.getAuthor());
            }
        }
    }

    private Author findAuthorByName(String name) {
        return authors.stream()
                      .filter(a -> a.getName().equalsIgnoreCase(name))
                      .findFirst()
                      .orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void printUsers() {
        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (User user : users) {
                System.out.println("- " + user.getName());
            }
        }
    }

    public Optional<User> findUserByName(String name) {
        return users.stream()
                    .filter(user -> user.getName().equalsIgnoreCase(name))
                    .findFirst();
    }
}