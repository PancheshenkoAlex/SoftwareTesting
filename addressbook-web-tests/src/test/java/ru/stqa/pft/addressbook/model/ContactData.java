package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String addressFirst;
    private String phoneHome;
    private String email;
    private String group;

    public ContactData(int id, String firstname, String lastname, String addressFirst, String phoneHome, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressFirst = addressFirst;
        this.email = email;
        this.phoneHome = phoneHome;
        this.group = group;
    }

    public ContactData() {
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

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddressFirst(String addressFirst) {
        this.addressFirst = addressFirst;
        return this;
    }

    public ContactData withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
