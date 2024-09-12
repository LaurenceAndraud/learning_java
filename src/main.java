import java.util.Scanner;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George R.R. Martin");
        library.addAuthor(author1);
        library.addAuthor(author2);

        Book book1 = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", 223, "Fantasy", 20.99, true);
        Book book2 = new Book("Game of Thrones", "George R.R. Martin", "Bantam Books", 694, "Fantasy", 24.99, true);
        library.addBook(book1);
        library.addBook(book2);

        while (true) {
            System.out.println("\nOptions :");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre");
            System.out.println("4. Lister les livres disponibles");
            System.out.println("5. Lister les utilisateurs");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            if (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un numéro valide.");
                scanner.next();  
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 1) {
                System.out.print("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                User user = new User(userName);
                library.addUser(user);
                System.out.println("Utilisateur ajouté : " + userName);

            } else if (choice == 2) {
                System.out.print("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                Optional<User> user = library.findUserByName(userName);
                if (user.isPresent()) {
                    System.out.print("Titre du livre à emprunter : ");
                    String title = scanner.nextLine();
                    library.borrowBook(title, user.get());
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }

            } else if (choice == 3) {
                System.out.print("Nom de l'utilisateur : ");
                String userName = scanner.nextLine();
                Optional<User> user = library.findUserByName(userName);
                if (user.isPresent()) {
                    System.out.print("Titre du livre à retourner : ");
                    String title = scanner.nextLine();
                    library.returnBook(title, user.get());
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }

            } else if (choice == 4) {
                System.out.println("Livres disponibles dans la bibliothèque :");
                library.printBooks();

            } else if (choice == 5) {
                System.out.println("Liste des utilisateurs :");
                library.printUsers();  

            } else if (choice == 6) {
                System.out.println("Fermeture du programme.");
                break;

            } else {
                System.out.println("Option invalide. Veuillez choisir entre 1 et 6.");
            }
        }

        scanner.close();
    }
}