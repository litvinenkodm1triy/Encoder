import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class EncryptedDecrypted {

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {
        if (flag) {
            ConsoleHelper.writeMessage("Введите адрес файла для его зашифровки");
        } else {
            ConsoleHelper.writeMessage("Введите адрес файла для его расшифровки");
        }

        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите ключ");
        int key = ConsoleHelper.readInt();


        Path dst = ConsoleHelper.buildFileName(src, flag ? "_encrypt" : "_decrypt");

        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encryptDecryp = flag ? caesar.encrypt(string, key) : caesar.decrypt(string, key);
                bufferedWriter.write(encryptDecryp + "\n");
            }
        }
    }
}
