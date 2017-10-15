public class EmployeProductionARisque extends  EmployeProduction{
    public EmployeProductionARisque(String nom, int age, int nombrePieceProduite) {
        super(nom, age, nombrePieceProduite);
    }

    @Override
    public float calculerSalaire() {
        return super.calculerSalaire()+200;
    }
}
