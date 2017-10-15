package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le chemin du fichier dans lequel vous souhaiter écrire :");
        String path = sc.nextLine();
        File file = new File(path);

        if (file.exists() && file.isFile() && file.canWrite()) {

            BufferedWriter bw;
            FileWriter fw;

            try {

                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                String line = "";
                int i = 1;

                System.out.println("[INFO] - Veuillez saisir la le contenu à ecrire sinon ecrire 'quit' :");

                while (!line.equalsIgnoreCase("quit")) {

                    System.out.print("   "+i++ +" - ");
                    line = sc.nextLine();

                    String newLine = System.getProperty("line.separator");

                    if (!line.equalsIgnoreCase("quit")) bw.write(line+newLine);
                }

                System.out.println("[INFO] -  fin de la saisie ");

                bw.close();
                fw.close();

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

            }

        } else {
            System.out.println("[ERREUR] - le chemin renseigné ne mene pas un fichier .");
        }

    }
}