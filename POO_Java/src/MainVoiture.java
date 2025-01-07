public class MainVoiture {
    public static void main(String[] args) {
        Voiture v0 = new Voiture("Peugeot", 2020, 4, "Essence", true, false, false, false);

        v0.demarrer();
        v0.avancer();
        v0.ralentir();
        v0.stopper();
    }
}
