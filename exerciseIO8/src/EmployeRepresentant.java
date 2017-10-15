public class EmployeRepresentant extends Employes {

        public float chiffreAffaire;

        public EmployeRepresentant(String nom, int age, int chiffreAffaire) {

            super(nom, age);
            this.chiffreAffaire = chiffreAffaire;
        }

        public float calculerSalaire() {
            return (float)((this.chiffreAffaire * 0.2) + 800);
        }
}

