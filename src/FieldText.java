
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Buffered reader

public class FieldText {
        private String pickLanguage;

        public static void main(String[] args) throws FileNotFoundException {
                setPickLanguage("Dansk");


        }


        public static String setPickLanguage(String Language) throws FileNotFoundException {

                if(Language.equals("Dansk") || Language.equals("Danish")){
                        File danishfile = new File("Dansk.txt");
                        Scanner scan = new Scanner(danishfile);


                        int filenum = (int) danishfile.length();
                        for(int i = 0; i < 1; i++) {
                                System.out.println(scan.nextLine());
                        }
                        return "Works";
                }
                else
                        return "Try Again";
        }
}
