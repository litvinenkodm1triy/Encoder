import java.io.*;
import java.util.Scanner;

public class Decrypted {
    // написать что делал, удалить
    public void decrypted() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите адрес файла для его расшифровки");
        String src = ConsoleHelper.readString();

        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Куда записать результат?");
        String dst = ConsoleHelper.readString();

        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dst))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String decrypt = caesar.decrypt(string, key);
                bufferedWriter.write(decrypt+"\n");
            }
        }
    }
}