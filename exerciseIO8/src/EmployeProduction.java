public class EmployeProduction extends Employes {

        public int nombrePieceProduite;

        public EmployeProduction(String nom, int age, int nombrePieceProduite) {

            super(nom, age);
            this.nombrePieceProduite = nombrePieceProduite;
        }

        public float calculerSalaire() {
            return (float)(this.nombrePieceProduite* 5);
        }

}
