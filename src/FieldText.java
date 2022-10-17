import java.io.*;

public class FieldText {
        private String pickLanguage;

        public static String setPickLanguage(String Language){

                if(Language.equals("Dansk") || Language.equals("Danish")){
                        File file = new File("DanishText.txt");
                        return "Try";
                }
                else
                        return "Try Again";
        }
}
