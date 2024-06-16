import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Bruteforce {
    private static final int MAX_LENGTH_WORD = 28;

    public void bruteforce() throws IOException {

        ConsoleHelper.writeMessage("Введите путь до файла");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Куда записать результат");
        Path dst = ConsoleHelper.buildFileName(src, "_bruteforce");

        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String string = reader.readLine();
                builder.append(string + "\n");
            }

            for (int i = 0; i < caesar.alphabetLength(); i++) {
                String decrypt = caesar.decrypt(builder.toString(), i);
                if (isValidateText(decrypt)) {
                    writer.write(decrypt);
                    ConsoleHelper.writeMessage("Содержимое расшифровано, ключ = "+i);
                    break;
                }

            }
        }
    }

    private boolean isValidateText(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            //как вывести кусок
            ConsoleHelper.writeMessage(text);
            ConsoleHelper.writeMessage("Понятен ли этот текст? (Yes/No)");
            String answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                isValidate = false;
            } else {
                ConsoleHelper.writeMessage("Выбрать можно только (Yes/No)");
            }
        }
        return false;
    }
}

