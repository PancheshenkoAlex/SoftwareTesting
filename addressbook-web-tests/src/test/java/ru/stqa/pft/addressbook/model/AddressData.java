package ru.stqa.pft.addressbook.model;

public class AddressData {
    private final String addressFist;
    private final String adressSecond;

    public AddressData(String addressFist, String adressSecond) {
        this.addressFist = addressFist;
        this.adressSecond = adressSecond;
    }

    public String getAddressFirst() {
        return addressFist;
    }

    public String getAdressSecond() {
        return adressSecond;
    }
}
