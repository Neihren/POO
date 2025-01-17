public class BanqueMain {
    public static void main(String[] args) {
        Banque b = new Banque("Crédit Mutuel", "Mulhouse");
        b.ajouteCompte(1245, "Robert", 2000, 300);
        b.ajouteCompte(2568, "Denis", 1000, 400);
        System.out.println(b.toString());
        System.out.println("\nLe compte avec le plus de fond :");
        System.out.println(b.compteSup());
        System.out.println("\n le compte avec l'id 2568 :");
        System.out.println(b.rendCompte(2568));
        System.out.println("\nTransfert entre deux comptes :");
        if (b.transferer(1245, 2568, 1000)) {
            System.out.println("Tranfert réussi");
        } else {
            System.out.println("Transfert échoué");
        }

    }
}
