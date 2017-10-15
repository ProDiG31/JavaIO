package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File fileWrite = null;
        File fileRead = null;
        Scanner sc = new Scanner(System.in);

        //Saisie du fichier a copier
        boolean fileToReadTargeted = false;
        while (!fileToReadTargeted) {
            System.out.println("veuillez saisir le chemin du fichier dont vous souhaiter copier le contenu :");
            String pathRead = sc.nextLine();
            fileRead = new File(pathRead);
            if (fileRead.exists() && fileRead.isFile() && fileRead.canRead()) fileToReadTargeted = true;
            else System.out.println("[ERREUR] - chemin incorrect ou fichier non lisible");
        }

        //Saisie du fichier dans lequel on copie le contenue
        boolean fileToWriteTargeted = false;
        while (!fileToWriteTargeted ) {
            System.out.println("veuillez saisir le chemin du fichier dans lequel vous souhaiter écrire :");
            String pathWrite = sc.nextLine();
            fileWrite = new File(pathWrite);
            if (fileWrite.exists() && fileWrite.isFile() && fileWrite.canWrite()) fileToWriteTargeted = true;
            else System.out.println("[ERREUR] - chemin incorrect ou fichier non modifiable");
        }

        if (fileRead != null && fileWrite != null) {

            FileReader fr;
            BufferedReader br;
            FileWriter fw;
            BufferedWriter bw;

            try {

                fr = new FileReader(fileRead);
                br = new BufferedReader(fr);
                fw = new FileWriter(fileWrite);
                bw = new BufferedWriter(fw);
                String content;
                int i = 1;

                while ((content = br.readLine()) != null) {
                    System.out.println("[INFO] - line " + i++ + " - " + content);

                    String newLine = System.getProperty("line.separator");

                    fw.append(content+newLine);
                }

                System.out.println("[INFO] - fin de la copie");

                bw.close();
                fw.close();
                br.close();
                fw.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }else {

            System.out.println("[ERREUR] - something went wrong :D ");

        }
        }
    }
