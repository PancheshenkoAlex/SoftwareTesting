package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private final String firstname;
    private final String lastname;
    private final String addressFirst;
    private final String phoneHome;
    private final String email;
    private String group;


    public ContactData(String firstname, String lastname, String addressFirst, String phoneHome, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressFirst = addressFirst;
        this.phoneHome = phoneHome;
        this.email = email;

        this.group = group;
    }



    public ContactData(int id, String firstname, String lastname, String addressFirst, String phoneHome, String email, String group) {
        this.id = id;
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

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
