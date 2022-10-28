package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class LanguageManager {
    private static final String resourcesFolderPath = "src/main/resources";
    private static final String defaultLanguage = "en";
    public static final String[] LangCodes;
    private static String[] names;
    private static String[] descriptions;
    private static HashMap<PlayerUpdate, String> playerUpdatePrompts;
    private static String winnerMessageDesign;
    private static String loserMessageDesign;

    static {
        names = new String[12];
        descriptions = new String[12];
        playerUpdatePrompts = new HashMap<>();
        for (PlayerUpdate update : PlayerUpdate.values()) {
            playerUpdatePrompts.put(update, update.name());
        }

        ArrayList<String> codes = new ArrayList<>();
        Pattern textFilePattern = Pattern.compile("text\\.[a-z][a-z]\\.ini");

        File resourcesFolder = new File(resourcesFolderPath);
        for (File f : Objects.requireNonNull(resourcesFolder.listFiles())) {
            if (!f.isFile()) {
                continue;
            }
            if (textFilePattern.matcher(f.getName()).find()) {
                codes.add(f.getName().split("\\.")[1]);
            }
        }

        LangCodes = new String[codes.size()];
        for (int i = 0; i < codes.size(); i++) {
            String currentCode = codes.get(i);
            LangCodes[i] = currentCode;
        }

        if (LangCodes.length == 0) {
            throw new RuntimeException("No language files");
        }
    }

    public static boolean langCodeExists(String langCode) {
        for (String code : LangCodes) {
            if (langCode.equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static boolean loadLanguage(String langCode) {
        if (!langCodeExists(langCode)) {
            return false;
        }
        File dataFile = new File(resourcesFolderPath + "/text."  + langCode + ".ini");

        decodeIni(dataFile);
        return true;
    }

    private static void decodeIni(File iniFile) {
        BufferedReader reader;
        try (FileReader fr = new FileReader(iniFile)) {
            reader = new BufferedReader(fr);

            String line;
            while (true) {
                try {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                }
                catch (IOException e) {
                    break;
                }

                line = line.strip();
                if (!line.contains("=")) {
                    continue;
                }
                String[] iniData = line.split("=");

                String key = iniData[0].strip();
                String value = iniData[1].strip();

                if (key.startsWith("Field")) {
                    key = key.replace("Field", "");

                    if (key.endsWith("Name")) {
                        int index = Integer.parseInt(key.replace("Name", "")) - 1;
                        names[index] = value;
                    }
                    else if (key.endsWith("Desc")) {
                        int index = Integer.parseInt(key.replace("Desc", "")) - 1;
                        descriptions[index] = value;
                    }
                }
                else if (key.endsWith("Prompt")) {
                    PlayerUpdate update = PlayerUpdate.valueOf(key.replace("Prompt", ""));
                    playerUpdatePrompts.replace(update, value);
                }
                else if (key.endsWith("Message")) {
                    if (key.startsWith("Winner")) {
                        winnerMessageDesign = value;
                    }
                    else if (key.startsWith("Loser")) {
                        loserMessageDesign = value;
                    }
                }
            }
        }
        catch (IOException e) {
            return;
        }
    }

    public static String[] getNames() {
        return names;
    }

    public static String[] getDescriptions() {
        return descriptions;
    }

    public static String getPrompt(PlayerUpdate promptType) {
        return playerUpdatePrompts.get(promptType);
    }

    public static String getWinnerMessageDesign() {
        return winnerMessageDesign;
    }

    public static String getLoserMessageDesign() {
        return loserMessageDesign;
    }

    public static String insertValuesInPrototype(String stringPrototype, Object... values) {
        String prompt = stringPrototype;
        for (int i = 0; i < values.length; i++) {
            String currentTarget = "{" + i + "}";
            prompt = prompt.replace(currentTarget, values[i].toString());
        }
        return prompt;
    }
}
