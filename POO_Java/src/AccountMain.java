import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountList accountList= new AccountList();
        String answer = "";
        do {
            System.out.println("\nInscription - 1\nConnection - 2\nQuitter - Q");
            System.out.print("Choix : ");
            answer = String.valueOf(sc.nextLine());
            if (answer.equals("1")) {
                accountList.signUp();
            } else if (answer.equals("2")) {
                if (accountList.getAccountNb() == 0) {
                    System.out.println("Il n'y a aucun compte");
                } else {
                    accountList.logIn();
                }
            } else if (answer.equals("q")) {
                System.out.println("A plus");
            } else if (answer.equals("t")) {
                System.out.println(accountList.toString());
            } else {
                System.out.println("Entrée incorrecte");
            }
        } while (!answer.equalsIgnoreCase("q"));

    }
}
