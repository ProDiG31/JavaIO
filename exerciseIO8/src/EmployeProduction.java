public class EmployeProduction extends Employes {

        public EmployeProduction(String nom,String prenom, int age,int anneeEntree, int nombrePieceProduite) {
            super(nom, prenom, age,anneeEntree, nombrePieceProduite);
        }

        @Override
        public float calculerSalaire() {
            return (float)(this.getUnite() * 5);
        }

}
