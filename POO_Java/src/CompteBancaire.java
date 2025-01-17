public class CompteBancaire {

    private int id;
    private String owner;
    private double balance;
    private double overdraft;

    public CompteBancaire() {
        this.id = 0;
        this.owner = "";
        this.balance = 0;
        this.overdraft = 0;
    }

    public CompteBancaire(int id, String owner, double balance, double overdraft) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        if (overdraft > 0) {
            overdraft = overdraft * -1;
        }
        this.overdraft = overdraft;
    }

    public CompteBancaire(CompteBancaire accountToClone) {
        this.id = accountToClone.id;
        this.owner = accountToClone.owner;
        this.balance = accountToClone.balance;
        this.overdraft = accountToClone.overdraft;
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

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public void credit(double amountToCredit) {
        System.out.println("\nSolde [" + this.id + "]: " + this.balance);
        this.balance += amountToCredit;
        System.out.println("Crédit de : " + amountToCredit);
        System.out.println("Nouveau solde [" + this.id + "]: " + this.balance);
    }

    public boolean debit(double amountToDebit) {
        System.out.println("\nSolde [" + this.id + "]: " + this.balance);
        if (this.balance - this.overdraft >= amountToDebit) {
            this.balance -= amountToDebit;
            System.out.println("Débit de : " + amountToDebit);
            System.out.println("Nouveau solde [" + this.id + "]: " + this.balance);
            return true;
        } else {
            System.out.println("Fonds insuffissant");
            return false;
        }
    }

    public boolean transfer(CompteBancaire beneficiary, double amountToTransfer) {
        boolean result;
        result = this.debit(amountToTransfer);
        if (result) {
            beneficiary.credit(amountToTransfer);
        }
        return result;
    }

    public boolean compare(CompteBancaire accountToCompare) {
        boolean result = (this.balance > accountToCompare.balance) ? true : false;
        System.out.print("\nSolde du compte [" + this.id + "] ");
        if (result) {
            System.out.print("supérieur ");
        } else {
            System.out.print("inférieur ");
        }
        System.out.print("au solde du compte [" + accountToCompare.id +"]");
        return result;
    }
}
