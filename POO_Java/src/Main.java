public class Main {
    public static void main(String[] args) throws Exception {
        
        Bouteille b1 = new Bouteille(true, 100, 10);
        b1.ouvrir();
        Bouteille b2 = (Bouteille) b1.clone();
        System.out.println(b1.toString());
        b1.remplir(70);
        System.out.println(b1.toString());

        b1.vider(50);
        System.out.println(b1.getContenuEnPourcentage());
        System.out.println(b2.toString());
    }
}
