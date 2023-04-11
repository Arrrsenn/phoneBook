import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final PhoneBook PHONE_BOOK = new PhoneBook();
    private static final String REGEX = "(.+)(\\s+\\d{11})";

    public static void main(String[] args) {
        while (true) {

            System.out.println("""
                    Введите команду:
                    0 - Выход
                    1 - Добавить контакт
                    2 - Вывод контактов
                    3 - Поиск
                    4 - Да
                    5 - Нет""");
            String input = new Scanner(System.in).nextLine();

            if (input.equals("0"))
                break;

            if (input.equals("1")) {

                System.out.println("Введите имя и номер:");
                String text = new Scanner(System.in).nextLine();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(text);

                if (matcher.find()) {
                    String name = matcher.group(1).trim();
                    String phone = matcher.group(2).trim();
                    PHONE_BOOK.addContact(phone, name);
                }

            }

            if (input.equals("2")) {
                PHONE_BOOK.getAllContacts();
            }

            if (input.equals("3")) {

                System.out.println("Введите имя и номер");

                String text = new Scanner(System.in).nextLine();

                System.out.println("Поиск...");

                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(text);

                if (matcher.find()) {
                    String name = matcher.group(1).trim();
                    String phone = matcher.group(2).trim();
                    PHONE_BOOK.getContactByPhone(phone);
                    PHONE_BOOK.getContactByName(name);
                } else {
                    System.out.println("Контакт не найден");
                }
            }
        }
    }
}

