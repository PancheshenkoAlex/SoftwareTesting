package ru.stqa.pft.addressbook.model;

public class ContactData {

    private final String firstname;
    private final String lastname;
    private final String addressFirst;
    private final String phoneHome;
    private final String email;
    private String group;


    public ContactData(String firstname, String lastname, String addressFirst, String phoneHome, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressFirst = addressFirst;
        this.phoneHome = phoneHome;
        this.email = email;

        this.group = group;
    }


    public String getHomePhone() {
        return phoneHome;
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

    public String getGroup() {
        return group;
    }
}
