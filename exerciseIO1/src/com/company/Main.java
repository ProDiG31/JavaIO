package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le chemin du répertoire que vous souhaiter lister :");
        String path = sc.nextLine();
        File file = new File(path);
        String s;

        if (file.exists() && file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                System.out.println(subFile.toString() + " - " + subFile.getAbsolutePath());
            }
        }

    }
}
