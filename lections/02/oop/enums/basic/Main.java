package tinkoff2.oop.enums.basic;

public class Main {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY;

        switch (day) {
            case MONDAY -> System.out.println("ПН");
            case TUESDAY -> System.out.println("ВТ");
            case WEDNESDAY -> System.out.println("СР");
            case THURSDAY -> System.out.println("ЧТ");
            case FRIDAY -> System.out.println("ПТ");
            case SATURDAY -> System.out.println("СБ");
            case SUNDAY -> System.out.println("ВС");
            default -> System.out.println("Что-то странное");
        }
    }
}
