public class CompteBancaireMain {
    public static void main(String[] args) {
        CompteBancaire c1 = new CompteBancaire(0001, "toto", 2000, 500);
        CompteBancaire c2 = new CompteBancaire(0002, "tutu", 2000, 500);
        
        c1.credit(20);
        c1.debit(2520);
        c1.credit(4000);
        c1.transfert(c2, 200);
        c1.compare(c2);
    }
}
