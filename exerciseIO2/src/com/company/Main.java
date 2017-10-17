package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le chemin du répertoire que vous souhaiter lister :");
        String path = sc.nextLine();
        File file = new File(path);

        String extensionChoice = "";
        boolean extSelected = false;
        
        while (!extSelected){
            System.out.println(" filtrages des extensions : ");
            System.out.println(" 1 - .py");
            System.out.println(" 2 - .php");
            System.out.println(" 3 - .txt");
            int choice = sc.nextInt();
            switch (choice){
                case (1) :
                    extensionChoice = "py";
                    extSelected = true;
                    break;
                case (2) :
                    extensionChoice = "php";
                    extSelected = true;
                    break;
                case (3) :
                    extensionChoice = "txt";
                    extSelected = true;
                    break;
                default :
                    System.out.println("Erreur : Choix non valide ");
                    break;
            }
        }

        System.out.println("Extension selectionnée = \'-"+ extensionChoice +"\'"+"\b");

        if (file.exists() && file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                int i = subFile.getName().lastIndexOf('.');
                String ext = subFile.getName().substring(i+1);
                if (extensionChoice.equals(ext)){
                    System.out.println(subFile.toString() + " - " + subFile.getAbsolutePath());
                }
            }
        }

    }

}
