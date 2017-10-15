
import java.util.Scanner;

public class Main {

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
            //s
            // CalculerSalaire();
        } else {
            System.out.println("[ERREUR] - choix non reconnu");
        }

    }

    private static void AjouterNouveauEmployé() {
        SystemeImpl sys = new SystemeImpl();
    }
}
