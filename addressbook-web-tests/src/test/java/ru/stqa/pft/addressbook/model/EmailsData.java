package ru.stqa.pft.addressbook.model;

public class EmailsData {
    private final String email_1;
    private final String email_2;
    private final String email_3;

    public EmailsData(String email_1, String email_2, String email_3) {
        this.email_1 = email_1;
        this.email_2 = email_2;
        this.email_3 = email_3;
    }

    public String getEmail_1() {
        return email_1;
    }

    public String getEmail_2() {
        return email_2;
    }

    public String getEmail_3() {
        return email_3;
    }
}
