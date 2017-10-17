public class EmployeProductionARisque extends  EmployeProduction{


    public EmployeProductionARisque(String nom, String prenom, int age,int anneeEntree, int nombrePieceProduite) {
        super(nom,prenom, age,nombrePieceProduite,anneeEntree);
    }

    @Override
    public float calculerSalaire() {
        return super.calculerSalaire()+200;
    }
}
