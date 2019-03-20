package ru.stqa.pft.addressbook.model;

public class ContactData {

    private final String firstname;
    private final String lastname;
    private final String addressFirst;
    private final String phoneHome;
    private final String phoneMobile;
    private final String email;
    private final String email2;


    public ContactData(String firstname, String lastname, String addressFirst, String phoneHome, String phoneMobile, String email, String email2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressFirst = addressFirst;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.email = email;
        this.email2 = email2;

    }


    public String getMobilePhone() {
        return phoneMobile;
    }

    public String getHomePhone() {
        return phoneHome;
    }

    public String getEmail_2() {
        return email2;
    }

    public String getEmail_1() {
        return email;
    }

    public String getLstName() {
        return lastname;
    }


    public String getName() {
        return firstname;
    }

    public String getAddressFirst() {
        return addressFirst;
    }
}
