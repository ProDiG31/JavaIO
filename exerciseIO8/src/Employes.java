import java.util.Date;

abstract class Employes {

    protected String nom;
    protected int age;
    protected Date dateEntree;

    public Employes (String nom, int age){
        this.nom        = nom;
        this.age        = age;
        this.dateEntree = new Date();
    }

    public abstract float calculerSalaire();

    public String getNom(){
        return this.nom;
    };
    public Date getDateEntree(){
        return this.dateEntree;
    }

}
