import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Ajouter quelques auteurs et livres de base
        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George R.R. Martin");
        library.addAuthor(author1);
        library.addAuthor(author2);

        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", 223, "Fantasy", 20.99, true);
        Book book2 = new Book("Game of Thrones", "George R.R. Martin", "Bantam Books", 694, "Fantasy", 24.99, true);
        library.addBook(book1);
        library.addBook(book2);

        while (true) {
            System.out.println("Options : 1. Ajouter un utilisateur 2. Emprunter un livre 3. Retourner un livre 4. Quitter");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne après l'input

            if (choice == 1) {
                System.out.println("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                User user = new User(userName);
                library.addUser(user);
                System.out.println("Utilisateur ajouté : " + userName);

            } else if (choice == 2) {
                System.out.println("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                Optional<User> user = library.findUserByName(userName);
                if (user.isPresent()) {
                    System.out.println("Titre du livre à emprunter : ");
                    String title = scanner.nextLine();
                    library.borrowBook(title, user.get());
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }

            } else if (choice == 3) {
                System.out.println("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                Optional<User> user = library.findUserByName(userName);
                if (user.isPresent()) {
                    System.out.println("Titre du livre à retourner : ");
                    String title = scanner.nextLine();
                    library.returnBook(title, user.get());
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }

            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}

