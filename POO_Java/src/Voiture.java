public class Voiture implements Cloneable {

    private String marque;
    private int annee;
    private int nbRoues;
    private String typeCarburant;
    private boolean moteur;
    private boolean contact;
    private boolean accelerateur;
    private boolean frein;

    public Voiture() {

    }

    public Voiture(String marque, int annee, int nbRoues, String typeCarburant, boolean moteur, boolean contact,
            boolean accelerateur, boolean frein) {
        this.marque = marque;
        this.annee = annee;
        this.nbRoues = nbRoues;
        this.typeCarburant = typeCarburant;
        this.moteur = moteur;
        this.contact = contact;
        this.accelerateur = accelerateur;
        this.frein = frein;
    }

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

    public String toString() {
        return "Voiture [marque=" + marque + ", annee=" + annee + ", nbRoues=" + nbRoues + ", typeCarburant="
                + typeCarburant + ", moteur=" + moteur + ", contact=" + contact + ", accelerateur=" + accelerateur
                + ", frein=" + frein + "]";
    }

    public boolean demarrer() {
        if (contact == true) {
            if (moteur == false) {
                this.moteur = true;
                System.out.println("La voiture est mainteant démarrée");
                return true;
            } else {
            System.out.println("La voiture est déjà démarrée");
            return false;
            }
        } else {
            System.out.println("Il n'y a pas le contact");
            return false;
        }
    }

    public void stopper() {
        if (moteur == true) {
            this.moteur = false;
            System.out.println("La voiture est maintenant à l'arrêt");
        } else {
            System.out.println("La voiture est déjà à l'arrêt");
        }
    }

    public void avancer() {
        if (moteur == true) {
            this.frein = false;
            this.accelerateur = true;
            System.out.println("La voiture avance");
        } else {
            System.out.println("La voiture n'est pas démarrée");
        }
    }
    
    public void ralentir() {
        if (moteur == true) {
            this.accelerateur = false;
            this.frein = true;
            System.out.println("La voiture freine");
        } else {
            System.out.println("La voiture n'est pas démarrée");
        }
    }
}
