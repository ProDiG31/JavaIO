import java.util.List;

public class Salaires {

    private List<Employes> listeEmploye;

    public Salaires (List<Employes> listeEmploye){
        this.listeEmploye = listeEmploye;

    }

    public void addEmploye(Employes employe){
        this.listeEmploye.add(employe);
    }

    public float getSalaireEmploye(){
        float total = 0F;
        for(Employes emp : this.listeEmploye){
            System.out.println("L'employé "+emp.getNom()+" a un salaire de : "+emp.calculerSalaire());
            total += emp.calculerSalaire();
        }
        return total;
    }

    public double getSalaireMoyen(){
        return getSalaireEmploye()/this.listeEmploye.size();
    }

    public List<Employes> getListeEmploye(){
        return this.listeEmploye;
    }

    public void setListeEmploye(List<Employes> listeEmploye) {
        this.listeEmploye = listeEmploye;
    }

}
