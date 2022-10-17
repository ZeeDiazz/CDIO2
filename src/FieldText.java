
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Buffered reader

public class FieldText {
        private String pickLanguage;

        public static void main(String[] args) throws FileNotFoundException {
                setPickLanguage("Dansk");


        }


        public static File setPickLanguage(String Language) throws FileNotFoundException {

                File danishfile = new File(Language + ".txt");
                Scanner scan = new Scanner(danishfile);

                return danishfile;
                }
}
