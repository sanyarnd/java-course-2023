package edu.hw3.task5;

import java.util.Arrays;
import java.util.Comparator;

public class ContactlList {
    public static String[] parseContacts(String[] contacts, String order) {
        if (contacts == null || contacts.length == 0) {
            return new String[0];
        }

        Arrays.sort(contacts, Comparator.comparing(ContactlList::getLastName));

        if (order.equals("DESC")) {
            reverseArray(contacts);
        }

        return contacts;
    }

    private static String getLastName(String contact) {
        String[] nameParts = contact.split(" ");
        if (nameParts.length > 1) {
            return nameParts[nameParts.length - 1];
        } else {
            return nameParts[0];
        }
    }

    private static void reverseArray(String[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            String temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
