package ru.stqa.pft.addressbook;

public class addressessGroup {
    private final String addressFist;
    private final String adressSecond;

    public addressessGroup(String addressFist, String adressSecond) {
        this.addressFist = addressFist;
        this.adressSecond = adressSecond;
    }

    public String getAddressFist() {
        return addressFist;
    }

    public String getAdressSecond() {
        return adressSecond;
    }
}
