public class EmployeManutentionARisque extends  EmployeManutention{

        public EmployeManutentionARisque(String nom, int age, int nombreHeure) {
            super(nom, age, nombreHeure);
        }

        @Override
        public float calculerSalaire() {
            return super.calculerSalaire()+200;
        }

}
