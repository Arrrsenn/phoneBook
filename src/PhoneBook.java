import java.util.*;

public class PhoneBook {

    HashMap<String, String> contact = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (contact.containsValue(phone)) {
            getContactByPhone(phone);
            for (Map.Entry<String, String> entry : contact.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (phone.equals(value)) {
                    contact.remove(key);
                    contact.put(name, phone);
                    return;
                }
            }
        }
        if (contact.containsKey(name)) {
            getContactByName(name);
            contact.put(name, contact.get(name) + ", " + phone);
        }
        if (!contact.containsKey(name)) {
            System.out.println("Такого имени в телефонной книге нет.\n" +
                    "Сохранить контакт \"" + name + "\"?\n" +
                    "Укажите команду: ");
            String cmdYesNo = new Scanner(System.in).nextLine();
            if (cmdYesNo.equals("4")) {
                contact.put(name, phone);
                System.out.println("Контакт \"" + name + "\" сохранен");
            }
        }

    }

    public void getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        System.out.println("Данный номер существует");
        if (contact.containsValue(phone)) {
            for (Map.Entry<String, String> entry : contact.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " - " + value);
                return;
            }
        }
        System.out.println("Контакт \"" + phone + "\" не найден");
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> personContact = new TreeSet<>();
        if (contact.containsKey(name)) {
            String person = name + " - " + contact.get(name);
            personContact.add(person);
            System.out.println(person);
            return personContact;
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> resultSet = new TreeSet<>();
        String person;
        if (!contact.isEmpty()) {
            System.out.println("Список контактов:");
            for (Map.Entry<String, String> entry : contact.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                person = key + " - " + value;
                System.out.println(person);
                resultSet.add(person);
            }
        } else {
            System.out.println("Журнал контактов пуст");
        }
        return new TreeSet<>(resultSet);
    }
}
