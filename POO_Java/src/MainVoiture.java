public class MainVoiture {
    public static void main(String[] args) {
        Voiture v0 = new Voiture("Peugeot", 2020, 4, "Essence", false, true, false, false);

        v0.demarrer();
        System.out.println(v0.toString());

        v0.avancer();
        System.out.println(v0.toString());

        v0.ralentir();
        System.out.println(v0.toString());

        v0.stopper();
        System.out.println(v0.toString());
        Voiture v1 = (Voiture) v0.clone();
        System.out.println(v1.toString());
    }
}
