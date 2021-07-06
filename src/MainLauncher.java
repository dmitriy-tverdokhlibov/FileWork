import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainLauncher {
    public static void main(String[] args) {
        File file = new File("worldWeb.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Width world Wide^# web wrong& Wesp wall?");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }

        FileWork flWork = new FileWork();
        String[] array = flWork.readFromFile("worldWeb.txt");

        System.out.println(Arrays.toString(array));
    }
}
