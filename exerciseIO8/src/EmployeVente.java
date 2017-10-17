public class EmployeVente extends Employes {

       public EmployeVente(String nom,String prenom, int age,int anneeEntree, int chiffreAffaire) {
        super(nom, prenom, age, anneeEntree, chiffreAffaire);
    }

    public float calculerSalaire() {
        return (float)((this.getUnite() * 0.2) + 400);
    }
}
