package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InputStream is = null;
        OutputStream os = null;

        //Saisie de l'image a copier
        //System.out.println("veuillez saisir le chemin de l'image que vous souhaiter copier  :");
        String pathImage = "C:\\Users\\RomainD\\Desktop\\JAVA\\testFile\\testF.jpg"; //sc.nextLine();


        //System.out.println("veuillez saisir le chemin du dossier dans lequel vous souhaiter copier l'image :");
        //String pathFolder = sc.nextLine();
        //System.out.println("veuillez saisir un nom pour le fichier que vous souhaiter copier  :");
        //String nameFile = sc.nextLine()+".jpg";

        String pathDest = "C:\\Users\\RomainD\\Desktop\\JAVA\\testFile\\imgcoppdzpdqp.jpg";
            //pathfolder+"."+nameFile;

        try {

            System.out.println("[INFO] - Ouverture du flux de lecture");
            is = new FileInputStream(new File(pathImage));
            System.out.println("[INFO] - Ouverture du flux d'écriture");
            os = new FileOutputStream(new File(pathDest));
            byte[] byteBuffer = new byte[1024];
            int length;
            int i = 0;
            System.out.println("[INFO] - Initiation du transfert");
            while ((length = is.read(byteBuffer)) > 0) {
                System.out.println("[INFO] - "+ ++i +" - Segment de 1024bits");
                os.write(byteBuffer, 0, length);
            }
            System.out.println("[INFO] - Fin du transfert");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("[INFO] - Fermeture du flux de lecture");
                is.close();
                System.out.println("[INFO] - Fermeture du flux d'écriture");
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
