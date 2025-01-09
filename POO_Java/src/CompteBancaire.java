public class CompteBancaire {

    private int id;
    private String owner;
    private double balance;
    private double overdraft;

    public CompteBancaire() {

    }

    public CompteBancaire(int id, String owner, double balance, double overdraft) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public String toString() {
        String result;

        result = "\n####################################";
        result += "\n# id = " + id;
        result += "\n# owner = " + owner;
        result += "\n# balance = " + balance;
        result += "\n# overdraft = " + overdraft;
        result += "\n####################################";
        return result;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        System.out.println("\nSolde [" + this.id + "]: " + this.balance);
        this.balance += amount;
        System.out.println("Crédit de : " + amount);
        System.out.println("Nouveau solde [" + this.id + "]: " + this.balance);
    }

    public boolean debit(double amount) {
        System.out.println("\nSolde [" + this.id + "]: " + this.balance);
        if (this.balance + this.overdraft >= amount) {
            this.balance -= amount;
            System.out.println("Débit de : " + amount);
            System.out.println("Nouveau solde [" + this.id + "]: " + this.balance);
            return true;
        } else {
            System.out.println("Fonds insuffissant");
            return false;
        }
    }

    public boolean transfert(CompteBancaire accountName, double amount) {
        boolean result;
        result = this.debit(amount);
        if (result) {
            accountName.credit(amount);
        }
        return result;
    }

    public boolean compare(CompteBancaire accountName) {
        boolean result = (this.balance > accountName.balance) ? true : false;
        System.out.print("\nSolde du compte [" + this.id + "] ");
        if (result) {
            System.out.print("supérieur ");
        } else {
            System.out.print("inférieur ");
        }
        System.out.print("au solde du compte [" + accountName.id +"]");
        return result;
    }
}
