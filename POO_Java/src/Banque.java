import java.util.ArrayList;
import java.util.List;

public class Banque {
    
    private List<CompteBancaire> mesComptes;
    private int nbComptes;
    private String nom;
    private String ville;

    public Banque(String nom, String ville) {
        this.mesComptes = new ArrayList<>();
        this.nbComptes = 0;
        this.nom = nom;
        this.ville = ville;
    }

    public void ajouteCompte(CompteBancaire unCompte) {
        this.mesComptes.add(unCompte);
        this.nbComptes++;
    }

    public void ajouteCompte(int id, String owner, double balance, double overdraft) {
        CompteBancaire compte = new CompteBancaire(id, owner, balance, overdraft);
        this.mesComptes.add(compte);
        this.nbComptes++;
    }

    public String toString() {
        String result;

        result = "mesComptes : \n " + this.mesComptes.toString();
        result += "\n nbCOmptes : " + this.nbComptes;
        result += "\n nom : " + this.nom;
        result += "\n ville : " + this.ville;

        return result;
    }

    public CompteBancaire compteSup() {
        CompteBancaire compteMax = mesComptes.get(0);
        for (CompteBancaire compteBancaire : mesComptes) {
            if (compteBancaire.getBalance() > compteMax.getBalance()) {
                compteMax = compteBancaire;
            }
        }
        return compteMax;
    }

    public CompteBancaire rendCompte(int id) {
        for (CompteBancaire compteBancaire : mesComptes) {
            if (compteBancaire.getId() == id) {
                return compteBancaire;
            }
        }
        return null;
    }

    public boolean transferer(int sourceId, int beneficiaryId, double amountToTransfer) {
        CompteBancaire sourceAccount;
        CompteBancaire beneficiaryAccount;
        
        sourceAccount = rendCompte(sourceId);
        beneficiaryAccount = rendCompte(beneficiaryId);
        
        return sourceAccount.transfer(beneficiaryAccount, amountToTransfer);
    }
}
