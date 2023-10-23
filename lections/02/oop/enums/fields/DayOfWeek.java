package tinkoff2.oop.enums.fields;

public enum DayOfWeek {
    MONDAY("ПН"),
    TUESDAY("ВТ"),
    WEDNESDAY("СП"),
    THURSDAY("ЧТ"),
    FRIDAY("ПТ"),
    SATURDAY("СБ"),
    SUNDAY("ВС");

    private String rusValue;

    DayOfWeek(String rusValue) {
        this.rusValue = rusValue;
    }

    public String getRusValue() {
        return rusValue;
    }
}
