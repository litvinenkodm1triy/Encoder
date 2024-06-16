import java.io.*;
import java.util.Scanner;

public class Encrypted {
    public void encrypted() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите адрес файла для его зашифровки");
        String src = scanner.nextLine();

        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Куда записать результат?");
        String dst = scanner.nextLine();

        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dst))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encrypt = caesar.encrypt(string, key);
                bufferedWriter.write(encrypt+"\n");
            }
        }
    }
}
