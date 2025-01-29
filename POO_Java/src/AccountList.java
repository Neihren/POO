import java.util.List;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    private List<Account> accounts;
    private int accountNb;
    private Scanner sc = new Scanner(System.in);

    public AccountList() {
        this.accounts = new ArrayList<>();
        this.accountNb = 0;
    }

    public void addAccount(Account accountToAdd) {
        this.accounts.add(accountToAdd);
        this.accountNb++;
    }

    public void addAccount(String name, String surname, String username, String password) {
        Account accountToAdd = new Account(name, surname, username, password);
        this.accounts.add(accountToAdd);
        this.accountNb++;
    }

    public String toString() {
        String result;

        result = "accounts :\n" + this.accounts.toString();
        result += "\n accountNb: " + this.accountNb;

        return result;
    }

    public Account getAccount(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public int getAccountNb() {
        return this.accountNb;
    }

    public boolean signUp() {
        Console console = System.console();
        String name;
        String surname;
        String username;
        String password;
        String confirmedPassword;
        String signUpConfirmation;
        System.out.println("\nPour vous inscrire merci de renseigner les élements suivants :");
        System.out.print("Nom : ");
        name = sc.nextLine();
        System.out.print("Prenom : ");
        surname = sc.nextLine();
        do {
            System.out.print("Nom utilisateur : ");
            username = sc.nextLine();
            for (Account account : accounts) {
                if (account.getUsername().equals(username)) {
                    username = "";
                    System.out.println("Nom utilisateur déjà existant, merci d'en indiquer un autre");
                }
            }
        } while (username.equals(""));
        do {
            do {
                password = new String(console.readPassword("Mot de passe : "));
                if (!password.matches(".*[0-9].*")) {
                    System.out.println("Le mot de passe doit contenir au moins un chiffre");
                    password = "";
                }
            } while (password.equals(""));
            confirmedPassword = new String(console.readPassword("Confirmation du mot de passe :"));
            if (!confirmedPassword.equals(password)) {
                System.out.println("Votre mot de passe doit être identique au premier.");
                confirmedPassword = "";
            }
        } while (confirmedPassword.equals(""));
        System.out.print("Validez-vous votre inscription (Y/N) ? ");
        signUpConfirmation = sc.nextLine();
        if (signUpConfirmation.equalsIgnoreCase("y")) {
            this.addAccount(name, surname, username, password);
            System.out.println("\nInscription terminée");
            return true;
        } else {
            System.out.println("\nAnnulation de la création de compte");
            return false;
        }
    }

    public boolean logIn() {
        Console console = System.console();
        String username;
        String password;
        String logInMessage;
        do {
            System.out.println("\nPour vous connecter, entrez");
            System.out.print("Nom Utilisateur : ");
            username = sc.nextLine();
            password = new String(console.readPassword("Mot de passe : "));
            Account account = getAccount(username);
            try {
                if (account.getPassword().equals(password)) {
                    logInMessage = "Bonjour " + account.getSurname() + " " + account.getName() + ", bienvenu sur votre espace utilisateur.";
                    System.out.println(logInMessage);
                    return true;
                } else {
                    System.out.println("Nom utilisateur ou mot de passe incorrecte.\n");
                }
            } catch (Exception e) {
                System.out.println("Nom utilisateur ou mot de passe incorrecte.");
            }
        } while (!username.equalsIgnoreCase("q") || !password.equalsIgnoreCase("q"));
        return false;
    }
}
