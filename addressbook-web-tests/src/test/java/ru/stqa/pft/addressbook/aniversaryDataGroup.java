package ru.stqa.pft.addressbook;

public class aniversaryDataGroup {
    private final String aDay;
    private final String aMonth;
    private final String aYear;

    public aniversaryDataGroup(String aDay, String aMonth, String aYear) {
        this.aDay = aDay;
        this.aMonth = aMonth;
        this.aYear = aYear;
    }

    public String getaDay() {
        return aDay;
    }

    public String getaMonth() {
        return aMonth;
    }

    public String getaYear() {
        return aYear;
    }
}
