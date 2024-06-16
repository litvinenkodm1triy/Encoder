import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Выберите дейтсвие, введя №");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - зашифровать текс, используя ключ");
            System.out.println("2 - расшифровать текс, используя ключ");
            System.out.println("3 - подобрать ключ, с помощью брутфорса и расшифровываем текст");
            System.out.println("4 - расшифровка текста с помощью синтаксического анализа");
            System.out.println("5- выход из программы");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> new EncryptedDecrypted().encryptedDecrypted(true);
                case 2 -> new EncryptedDecrypted().encryptedDecrypted(false);
                case 3 -> System.out.println("Выполняется сценарий 3");
                case 4 -> System.out.println("Выполняется сценарий 4");
                case 5 -> {
                    return;
                }
            }
        }
    }
}