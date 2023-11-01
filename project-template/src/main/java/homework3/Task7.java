package homework3;

import java.util.Comparator;

public class Task7 implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return 0;
        } else if (str1 == null) {
            return -1; // ������� null ���������� ���������
        } else if (str2 == null) {
            return 1; // ������� null ���������� ���������
        } else {
            return str1.compareTo(str2);
        }
    }
}
