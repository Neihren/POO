// Déclaration de la classe Bouteille
// "implements Cloneable" permet de clonage des objets
public class Bouteille implements Cloneable {

    // Attributs
    private boolean estOuvert;
    private float contenanceEnML;
    private float contenuEnPourcentage;

    // Constructeur par defaut
    public Bouteille() {
        this.estOuvert = false;
        this.contenanceEnML = 100;
        this.contenuEnPourcentage = 100;
    }

    // Constructeur classique
    // This. sert à indiquer un objet particulier
    public Bouteille(boolean estOuvert, float contenanceEnML, float contenuEnPourcentage) {
        this.estOuvert = estOuvert;
        this.contenanceEnML = contenanceEnML;
        this.contenuEnPourcentage = contenuEnPourcentage;
    }

    // Constructeur par clonage
    public Bouteille(Bouteille bouteilleACloner) {
        this.estOuvert = bouteilleACloner.estOuvert;
        this.contenanceEnML = bouteilleACloner.contenanceEnML;
        this.contenuEnPourcentage = bouteilleACloner.contenuEnPourcentage;
    }

    // Autre constructeur par clonage
    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la
            // méthode super.clone()
            o = super.clone();
        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver, car nous implémentons
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }

    // Methode toString pour afficher tous les attributs de l'objet
    public String toString() {
        return "Bouteille [estOuvert=" + estOuvert + ", contenanceEnML=" + contenanceEnML + ", contenuEnPourcentage="
                + contenuEnPourcentage + "]";
    }

    // getter qui renvoie l'état de l'attribut estOuvert
    // de type boolean
    public boolean getEstOuvert() {
        return estOuvert;
    }

    // setter qui permet de changer l'état de l'attribut estOuvert
    // de type void car elle ne renvoi rien
    public void setEstOuvert(boolean estOuvert) {
        this.estOuvert = estOuvert;
    }

    // getter qui renvoie l'état de l'attribut contenanceEnML
    // de type float
    public float getcontenanceEnML() {
        return contenanceEnML;
    }

    // setter qui permet de changer l'état de l'attribut contenanceEnML
    // de type void car elle ne renvoi rien
    public void setContenanceEnML(float contenanceEnML) {
        this.contenanceEnML = contenanceEnML;
    }

    // getter qui renvoie l'état de l'attribut contenuEnPourcentage
    // de type float
    public float getContenuEnPourcentage() {
        return contenuEnPourcentage;
    }

    // setter qui permet de changer l'état de l'attribut contenuEnPourcentage
    // de type void car elle ne renvoi rien
    public void setContenuEnPourcentage(float contenuEnPourcentage) {
        this.contenuEnPourcentage = contenuEnPourcentage;
    }

    /*
     * Operation/Méthode ouvrir()
     * - Vérifie si la bouteille n'est pas déjà ouverte
     * - Si elle est fermée, permet son ouverture et renvoie true
     */
    public boolean ouvrir() {
        if (estOuvert == true) {
            System.out.println("Impossible la bouteille est déjà ouverte");
            return false;
        } else {
            this.estOuvert = true;
            System.out.println("La bouteille est maintenant ouverte");
            return true;
        }
    }

    /*
     * Operation/Méthode fermer()
     * - Vérifie si la bouteille n'est pas déjà fermée
     * - Si elle est ouverte, permet son ouverture et renvoie true
     */
    public boolean fermer() {
        if (estOuvert == false) {
            System.out.println("Impossible la bouteille est déjà fermée");
            return false;
        } else {
            this.estOuvert = false;
            System.out.println("La bouteille est maintenant fermée");
            return true;
        }
    }

    /*
     * Méthode vider()
     * - Vérifie si la bouteille est ouverte :
     * - Si c'est le cas, permet le vidage total
     * - Si ce n'est pas le cas empêche le vidage car la bouteille est fermée
     */
    public boolean vider() {
        if (estOuvert == false) {
            System.out.println("La bouteille doit déjà être ouverte");
            return false;
        } else if (contenuEnPourcentage == 0f) {
            System.out.println("La bouteille est déjà vide");
            return false;
        } else {
            this.contenuEnPourcentage = 0f;
            System.out.println("La bouteille est maintenant vide");
            return true;
        }
    }

    /*
     * Surcharge de la méthode vider(float pourcentageAVider)
     * -> Surcharge (Overload en anglais) est une méthode de même nom qu'une méthode
     * existante
     * mais avec des paramètres différents et l'exécution est donc différente
     * également
     */
    public boolean vider(float pourcentageAVider) {
        // Vérifie si la bouteille est ouverte
        if (estOuvert == false) {
            System.out.println("La bouteille doit déjà être ouverte");
            return false;
            // Vérifie si la bouteille n'est pas déjà vide
        } else if (contenuEnPourcentage == 0f) {
            System.out.println("La bouteille est déjà vide");
            return false;
            // Vérifie si l'on ne tente pas de vidé plus que le contenu de la bouteille
        } else if (contenuEnPourcentage - pourcentageAVider < 0f) {
            System.out.println("La bouteille n'est remplie qu'à " + contenuEnPourcentage
                    + "%, impossible de la vider de " + pourcentageAVider + "%");
            return false;
        } else {
            // Vide la bouteille
            this.contenuEnPourcentage = contenuEnPourcentage - pourcentageAVider;
            // Si la bouteille est maintenant vide
            if (contenuEnPourcentage == 0f) {
                System.out.println("La bouteille est maintenant vide");
                return true;
            } else {
                System.out.println("La bouteille est maintenant pleine à " + contenuEnPourcentage + "%");
                return true;
            }
        }
    }

    // Méthode remplir()
    public boolean remplir() {
        // Vérifie si la bouteille est bien ouverte
        if (estOuvert == false) {
            System.out.println("La bouteille doit déjà être ouverte");
            return false;
            // Si la bouteille est déjà pleine, empêche le remplissage
        } else if (contenuEnPourcentage == 100f) {
            System.out.println("La bouteille est déjà pleine");
            return false;
            // Remplie la bouteille
        } else {
            this.contenuEnPourcentage = 100f;
            System.out.println("La bouteille est maintenant pleine");
            return true;
        }
    }

    // Méthode vider()
    public boolean remplir(float pourcentageARemplir) {
        // Vérifie si la bouteille est bien ouverte
        if (estOuvert == false) {
            System.out.println("La bouteille doit déjà être ouverte");
            return false;
            // Vérifie si la bouteille n'est pas déjà pleine
        } else if (contenuEnPourcentage == 100f) {
            System.out.println("La bouteille est déjà pleine");
            return false;
            // Vérifie si l'on ne tente pas de trop remplir la bouteille
        } else if (contenuEnPourcentage + pourcentageARemplir > 100f) {
            System.out.println("La bouteille est déjà remplie à " + contenuEnPourcentage
                    + "%, impossible de la remplir de " + pourcentageARemplir + "%");
            return false;
            // Remplie la bouteille
        } else {
            this.contenuEnPourcentage = contenuEnPourcentage + pourcentageARemplir;
            if (contenuEnPourcentage == 100f) {
                System.out.println("La bouteille est maintenant pleine");
                return true;
            } else {
                System.out.println("La bouteille est maintenant pleine à " + contenuEnPourcentage + "%");
                return true;
            }
        }
    }
}
