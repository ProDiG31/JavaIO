
import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    private static String [] professionPossible = {  "EmployeManutention",
                                    "EmployeManutentionARisque",
                                    "EmployeProduction",
                                    "EmployeProductionARisque",
                                    "EmployeRepresentant",
                                    "EmployeVente"  };

    public static void main(String[] args) {
        // write your code here


        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue sur le systeme de calcul de salaire :");
        System.out.println("vous souhaitez :");

        String choice = "";
        while (!(choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("c"))){
            System.out.println("Ajouter un nouvel employé au systeme ? - (s\\S)");
            System.out.println("Calculer les salaires ? - (c\\C) ");

            choice = sc.nextLine();
            if (!(choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("c"))){
                System.out.println("[ERREUR] - choix non reconnu, veuillez recommencer : ");
            }
        }
        if (choice.equalsIgnoreCase("s")){
            System.out.println("[INFO] - Choix confirmé : Ajouter un nouvel employé ");
            AjouterNouveauEmployé();
        }
        else if (choice.equalsIgnoreCase("c")){
            System.out.println("[INFO] - Choix confirmé : Calculer les salaires ");
            CalculerSalaire();

        } else {
            System.out.println("[ERREUR] - choix non reconnu");
        }

    }

    private static void CalculerSalaire(){
        File folder = new File ("data");
        int salaire = 0;
        if (folder.exists() && folder.isDirectory()){
            for (File f : folder.listFiles()){
                FileInputStream inputStreamFile = null;
                BufferedInputStream inputStreamBuffered = null;
                try {
                    inputStreamFile = new FileInputStream(f);
                    inputStreamBuffered = new BufferedInputStream(inputStreamFile);
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStreamBuffered);
                    Employes obj = (Employes)objectInputStream.readObject();

                    if (inputStreamBuffered != null)
                        objectInputStream.close();
                    if (inputStreamFile != null)
                        inputStreamFile.close();

                    System.out.println(obj.toString()+" salaire = "+ obj.calculerSalaire() );
                    salaire +=  obj.calculerSalaire();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("salaire total = "+salaire);
    }
    private static void AjouterNouveauEmployé() {
        System.out.println("[INFO] - Selectionnée la fonction de l'employé ");
        System.out.println("   1 - Employé de Manutention ");
        System.out.println("   2 - Employé de Manutention à risque");
        System.out.println("   3 - Employé de Production ");
        System.out.println("   4 - Employé de Production à risque ");
        System.out.println("   5 - Employé représentant ");
        System.out.println("   6 - Employé en Vente");
        Scanner sc = new Scanner(System.in);

        int role;
        String nom;
        String prenom;
        int age;
        int annee;
        String uniteTpe;

        do {
            role = sc.nextInt();
        } while (role > 6 && role < 1);

        System.out.println("[INFO] - Saisir le nom de l'employé ");
        nom = sc.next();


        System.out.println("[INFO] - Saisir le prenom de l'employé ");
        prenom = sc.next();

        System.out.println("[INFO] - Saisir l' age de l'employé ");
        age = sc.nextInt();

        System.out.println("[INFO] - Saisir l' année d' entrée de l'employé ");
        annee = sc.nextInt();


        if (role == 1 || role == 2){
            uniteTpe = "le nombre d'heure de";
        } else if (role == 3 || role == 4){
            uniteTpe = "le nombre de Pieces Produites par";
        } else {
            uniteTpe ="le chiffre d'affaire de";
        }

        System.out.println("[INFO] - Saisir "+uniteTpe+" l'employé ");
        int unite = sc.nextInt();

        String nomClass = professionPossible[role - 1];
        Employes emp;

        Class [] paramTypes = {nom.getClass(),prenom.getClass(),int.class,int.class,int.class};
        Object [] paramValues = {  nom,prenom,age,annee,unite };

        try {

            Class<Employes> classeReflect = (Class<Employes>) Class.forName(nomClass);
            Constructor<Employes> constructeur = classeReflect.getConstructor(paramTypes);
            emp = constructeur.newInstance(paramValues);

            System.out.println("[INFO] - employé crée ");
            System.out.println(emp.toString());
            System.out.println(emp.calculerSalaire());
            System.out.println("Enregistrement CSV : "+emp.toStringCSV());
            System.out.println("Confirmer l' enregistrement ? (O/N)");
            if(sc.next().equalsIgnoreCase("o")){
                System.out.println("Enregistrement CSV validé  ");
                addEmploye(emp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void addEmploye( Employes emp ) {
        FileOutputStream outputStreamFile = null;
        ObjectOutputStream outputStreamObj = null;
        try {
            outputStreamFile = new FileOutputStream("data/employeData"+emp.getNom()+emp.getPrenom());
            outputStreamObj = new ObjectOutputStream(outputStreamFile);
            outputStreamObj.writeObject(emp);

            System.out.println("[INFO] - employe sauvegardé avec succes");

            if(outputStreamObj != null)
                outputStreamObj.close();
            if(outputStreamFile != null)
                outputStreamFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object delEmploye(Employes emp){

        FileInputStream inputStreamFile = null;
        BufferedInputStream inputStreamBuffered = null;
        try {
            inputStreamFile = new FileInputStream("data/employeData"+emp.getNom()+emp.getPrenom());
            inputStreamBuffered = new BufferedInputStream(inputStreamFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStreamBuffered);
            Object obj = objectInputStream.readObject();

            if (inputStreamBuffered != null)
                objectInputStream.close();
            if (inputStreamFile != null)
                inputStreamFile.close();

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
