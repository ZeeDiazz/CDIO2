package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Buffered reader

public class FieldText {
    public static void main(String[] args) throws FileNotFoundException {
        String[] pickLanguage = setPickLanguage("Dansk");

        for (int i = 0; i < pickLanguage.length; i++) {
            System.out.println(pickLanguage[i]);
        }
    }


    public static String[] setPickLanguage(String Language) throws FileNotFoundException {

        File danishfile = new File(Language + ".txt");
        Scanner scan = new Scanner(danishfile);

        //Fordi der er 16 linjer
        String[] data = new String[16];
        for (int i = 0; i < data.length; i++) {
            scan.hasNextLine();
            data[i] = scan.nextLine();
            //System.out.println(data[i]);


        }


        return data;
    }
}
