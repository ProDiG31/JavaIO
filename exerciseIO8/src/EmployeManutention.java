public class EmployeManutention extends Employes {

    public EmployeManutention(String nom, String prenom, int age,int anneeEntree, int nombreHeure) {
        super(nom, prenom, age , anneeEntree, nombreHeure);
    }

    @Override
    public float calculerSalaire() {
            return (float)((this.getUnite() * 65));
    }


}
