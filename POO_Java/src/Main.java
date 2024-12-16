public class Main {
    public static void main(String[] args) throws Exception {
        
        // Instanciation de l'objet b0 de la classe Bouteille par constructeur par défaut
        Bouteille b0 = new Bouteille();
        // Instanciation de l'objet b1 de la classe Bouteille par constructeur classique
        Bouteille b1 = new Bouteille(true, 100, 10);
        // Instanciation de l'objet b2 de la classe Bouteille par constructeur par clonage
        Bouteille b2 = (Bouteille) b1.clone();
        
        // Affichage des etats de l'objet b1 avec la méthode toString()
        System.out.println(b1.toString());
        
        // Fermeture de l'objet b1 avec la méthode fermer()
        b1.fermer();

        // Ouverture de l'objet b1 avec la méthode ouvrir()
        b1.ouvrir();

        // Remplissage de l'objet b1 avec la méthode remplir()
        b1.remplir();

        // Vidage de l'objet b1 avec la méthode vider()
        b1.vider();

        // Remplissage partiel de l'objet b1 avec la méthode remplir(float pourcentageARemplir)
        b1.remplir(50);

        // Vidage partiel de l'objet b1 avec la méthdode vider(float pourcentageAVider)
        b1.vider(20);
    }
}
