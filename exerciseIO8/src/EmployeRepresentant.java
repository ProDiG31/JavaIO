public class EmployeRepresentant extends Employes {

    public EmployeRepresentant(String nom, String prenom, int age, int anneeEntree, int chiffreAffaire) {
        super(nom, prenom, age, anneeEntree, chiffreAffaire);
    }

    @Override
    public float calculerSalaire() {
            return (float)((this.getUnite() * 0.2) + 800);
        }
}

