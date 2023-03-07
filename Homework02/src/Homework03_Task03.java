import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * В файле содержится строка с данными:
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}].
 *
 * Напишите метод, который разберёт её на составные части и,
 * используя StringBuilder, создаст массив строк такого вида:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */
public class Homework03_Task03 {
    public static void main(String[] args) {
        String textFromFile = readFile("./Task03Start");
        System.out.println("Текст из файла:\n" + textFromFile);
        System.out.println();
        System.out.println("Результат:\n" + createStr(createSplitArr(removeSquareBrackets(textFromFile))));
    }

    private static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultLine = sb.toString().trim();
        return resultLine;
    }

    private static String removeSquareBrackets(String str) {
        if (str != null && str.length() > 0) {
            if (str.charAt(0) == '[') {
                str = str.substring(1);
            }
            int strLength = str.length();
            if (str.charAt(strLength - 1) == ']') {
                str = str.substring(0, strLength - 1);
            }
        }
        return(str);
    }

    private static String[] createSplitArr(String str) {
        String[] splitStr = str.split("},");
        for (int i = 0; i < splitStr.length; i++) {
            splitStr[i] = splitStr[i].replace("{", "").replace("}", "").replace("\"", "").trim();
        }

        return splitStr;
    }

    private static String createStr(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String i: arr) {
            String[] arrStr = i.split(",");
            ArrayList<String> al = new ArrayList<>();
            for (String j: arrStr) {
                int pos = j.lastIndexOf(":");
                al.add(j.substring(pos + 1));
            }
            sb.append("Студент " + al.get(0) + " получил " + al.get(1) + " по предмету " + al.get(2) + ".\n");
        }
        return sb.toString();
    }
}
