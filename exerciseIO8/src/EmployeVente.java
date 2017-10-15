public class EmployeVente extends Employes {

    public float chiffreAffaire;

    public EmployeVente(String nom, int age, int chiffreAffaire) {

        super(nom, age);
        this.chiffreAffaire = chiffreAffaire;
    }

    public float calculerSalaire() {
        return (float)((this.chiffreAffaire * 0.2) + 400);
    }
}
