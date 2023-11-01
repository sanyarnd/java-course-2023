package homework3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record Task5(String fullName) {

    public String getLastName() {
        String[] names = fullName.split(" ");
        if (names.length > 1) {
            return names[names.length - 1];
        } else {
            return names[0];
        }
    }

    @Override
    public String toString() {
        return fullName;
    }

    public static List<Task5> parseContacts(String[] names, String sortOrder) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }

        List<Task5> contacts = new ArrayList<>();
        for (String name : names) {
            contacts.add(new Task5(name));
        }

        if ("ASC".equals(sortOrder)) {
            contacts.sort(Comparator.comparing(Task5::getLastName));
        } else if ("DESC".equals(sortOrder)) {
            contacts.sort(Comparator.comparing(Task5::getLastName).reversed());
        }

        return contacts;
    }

}
