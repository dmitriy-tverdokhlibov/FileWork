import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String sentence;
        char W = 'W';

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            sentence = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] splitArray = sentence.split("\\W+");

        int count = 0;
        for (String s : splitArray) {
            if (String.valueOf(s.charAt(0)).compareToIgnoreCase(String.valueOf(W)) == 0) {
                count++;
            }
        }

        String[] result = new String[count];

        count = 0;
        for (String s : splitArray) {
            if (String.valueOf(s.charAt(0)).compareToIgnoreCase(String.valueOf(W)) == 0) {
                result[count] = s.toLowerCase();
                count++;
            }
        }

        Arrays.sort(result);

        return result;
    }
}
