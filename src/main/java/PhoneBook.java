import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    static Map<String, Integer> phoneBook = new TreeMap<>();

    public static Map<String, Integer> getPhoneBook() {
        return phoneBook;
    }

    public static int add(String name, int phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.putIfAbsent(name, phoneNumber);
        }
        return phoneBook.size();
    }

    static String findByNumber(int phoneNumber) {
        Set<Map.Entry<String, Integer>> entrySet = phoneBook.entrySet();
        String name = null;
        for (Map.Entry<String, Integer> nameNumberPair : entrySet) {
            if (phoneNumber == nameNumberPair.getValue()) {
                name = nameNumberPair.getKey();
            }
        }
        return name;
    }

    public static Integer findByName(String name) {
        return phoneBook.get(name);
    }

    public static String printAllNames() {
        StringBuilder sb = new StringBuilder();
        if (phoneBook.isEmpty()) {
            return "No contacts";
        }
        for (Map.Entry<String, Integer> entry : phoneBook.entrySet()) {
            sb.append(entry.getKey()).append(" ");
        }
        return sb.toString();
    }
}

