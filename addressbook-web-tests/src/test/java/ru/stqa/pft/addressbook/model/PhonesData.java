package ru.stqa.pft.addressbook.model;

public class PhonesData {
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;
    private final String phone2;

    public PhonesData(String homePhone, String mobilePhone, String workPhone, String fax, String phone2) {
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.phone2 = phone2;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getPhone2() {
        return phone2;
    }
}
