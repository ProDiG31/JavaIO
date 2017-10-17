import java.io.Serializable;

abstract class Employes  implements Serializable {

    protected String nom;
    protected String prenom;
    protected int age;
    protected int unite;
    protected int anneeEntree;

    public Employes (String nom,String prenom, int age,int anneeEntree,int unite ){
        this.nom        = nom;
        this.prenom     = prenom;
        this.age        = age;
        this.unite      = unite;
        this.anneeEntree = anneeEntree;
    }

    @Override
    public String toString() {
        return "Employé de fonction : "+ this.getClass()+" nom :"+this.nom+""+this.prenom+", age : "+this.age+" ";
    }

    public String toStringCSV(){
        return (this.getClass()+","+this.nom+","+this.prenom+","+this.age+","+this.anneeEntree+","+this.getUnite());
    }

    public abstract float calculerSalaire();

    public String getNom(){
        return this.nom;
    }
    public String getPrenom() { return prenom; }
    public int getAnneeEntree(){
        return this.anneeEntree;
    }
    public int getUnite(){ return this.unite; }

}
