import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * В файле содержится строка с исходными данными в такой форме:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}.
 * Требуется на её основе построить и вывести на экран новую строку
 * в форме SQL запроса:
 *
 * SELECT * FROM students
 * WHERE name = "Ivanov"
 * AND country = "Russia"
 * AND city = "Moscow".
 *
 * Для разбора строки используйте String.split.
 * Сформируйте новую строку, используя StringBuilder.
 * Значения null не включаются в запрос.
 */
public class Homework02_Task01 {
    public static void main(String[] args) {
        String textFromFile = readFile("./Task01Start");
        System.out.println("Строка в файле:");
        System.out.println(textFromFile);
        System.out.println("Запрос SQL:");
        System.out.println(createSqlLine(splitText(textFromFile)));
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
        String resultLine = sb.toString();
        return resultLine;
    }

    private static String[] splitText(String text) {
        text = text.replace("{", "").replace("}", "").replace("\"", "");
        String[] splitTextbyComma = text.split(",");
        return splitTextbyComma;
    }

    private static String createSqlLine(String[] textArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM students WHERE ");
        for (int i = 0; i < textArr.length; i++) {
            String[] splitTextByColon = textArr[i].split(":");
            boolean isNull = splitTextByColon[1].trim().equalsIgnoreCase("null");
            if (!isNull) {
                if (!sb.substring(sb.length() - 6).trim().equalsIgnoreCase("where")) sb.append(" AND ");
                sb.append(splitTextByColon[0].trim()).append(" = ").append(splitTextByColon[1].trim());
            }
        }
        return sb.toString();
    }
}
