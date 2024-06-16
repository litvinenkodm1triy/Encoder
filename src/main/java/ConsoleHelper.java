import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class ConsoleHelper {
    private final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string;
        try {
            string = READER.readLine();
        } catch (IOException e) {
            writeMessage("произошла ошибка при попытке вводе текста, попробуйте еще раз");
            string = readString();
        }
        return string;
    }

    public static int readInt() {
        int integer;
        try {
            integer = Integer.parseInt(READER.readLine());
        } catch (IOException e) {
            writeMessage("произошла ошибка при попытке вводе текста, попробуйте еще раз");
            integer = readInt();
        }
        return integer;
    }

    public static Path buildFileName(String path, String suffix)  {

        Path fullPath = Path.of(path);
        Path parent = fullPath.getParent();
        String fileName = fullPath.getFileName().toString();
        String newFileName;
        if (fileName.contains(".")) {
            int index = fileName.indexOf(".");
            newFileName = fileName.substring(0, index) + suffix + fileName.substring(index);
        } else {
            newFileName = fileName + suffix;
        }
        return parent.resolve(newFileName);
    }

}
