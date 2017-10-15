import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class SalairesTest {

    private Salaires Salaire;

    @Before
    public void setUps(){
        LinkedList<Employes> listeEmploye = new LinkedList<>();
        this.Salaire = new Salaires(listeEmploye);
    }

    @After
    public void tearsDown(){
        this.Salaire = null;
    }

    @Test
    public void testEmployeVente(){
        Employes emp1 = new EmployeVente("Joseph",23,2300);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)((2300 * 0.2) + 400));
    }


    @Test
    public void testEmployeRepresentant(){
        Employes emp1 = new EmployeRepresentant("Joseph",23,2300);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)((2300 * 0.2) + 800));
    }

    @Test
    public void testEmployeProduction(){
        Employes emp1 = new EmployeProduction("Joseph",23,500);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)(2500));
    }

    @Test
    public void testEmployeManutention(){
        Employes emp1 = new EmployeManutention("Joseph",23,135);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)(135 * 65));
    }

    @Test
    public void testEmployeManutentionARisque(){
        Employes emp1 = new EmployeManutentionARisque("Joseph",23,135);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)(135 * 65) + 200);
    }

    @Test
    public void testEmployeProductionARisque(){
        Employes emp1 = new EmployeProductionARisque("Joseph",23,500);
        this.Salaire.addEmploye(emp1);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)(2700));
    }

    @Test
    public void test2Employe(){
        Employes emp1 = new EmployeManutention("Joseph",23,135);
        Employes emp2 = new EmployeManutentionARisque("Joseph",23,135);

        this.Salaire.addEmploye(emp1);
        this.Salaire.addEmploye(emp2);
        assertEquals(this.Salaire.getSalaireEmploye(),(float)(17750));
    }

    @Test
    public void test2EmployeSalaireMoyen(){
        Employes emp1 = new EmployeManutention("Joseph",23,135);
        Employes emp2 = new EmployeManutentionARisque("Joseph",23,135);

        this.Salaire.addEmploye(emp1);
        this.Salaire.addEmploye(emp2);
        assertEquals(this.Salaire.getSalaireMoyen(),(double)(8875));
    }
}
