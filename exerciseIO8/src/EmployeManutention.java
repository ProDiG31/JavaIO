public class EmployeManutention extends Employes {

        public int nombreHeure;

        public EmployeManutention(String nom, int age, int nombreHeure) {

            super(nom, age);
            this.nombreHeure = nombreHeure;
        }

        public float calculerSalaire() {
            return (float)((this.nombreHeure * 65));
        }


}
