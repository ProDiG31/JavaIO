public class EmployeManutentionARisque extends  EmployeManutention{

        public EmployeManutentionARisque(String nom, String prenom, int age,int anneeEntree, int nombreHeure) {
            super(nom, prenom, age, anneeEntree, nombreHeure);
        }

        @Override
        public float calculerSalaire() {
            return super.calculerSalaire()+200;
        }

}
