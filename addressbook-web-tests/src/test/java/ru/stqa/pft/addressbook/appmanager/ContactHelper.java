package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillPersonalData(PersonalData personalData) {
        type(By.name("firstname"), personalData.getName());
        type(By.name("middlename"), personalData.getMiddleName());
        type(By.name("nickname"), personalData.getNickName());
        type(By.name("lastname"), personalData.getLstName());
    }

    public void addNotes(String notes) {
        type(By.name("notes"), notes);
    }

    public void addGroup(String group) {
        selectDropdownValue(By.name("new_group"), group);
    }

    public void fillAniversaryInfo(AniversaryData aniversaryDataGroup) {
        selectDropdownValue(By.name("aday"), aniversaryDataGroup.getaDay());
        selectDropdownValue(By.name("amonth"), aniversaryDataGroup.getaMonth());
        type(By.name("ayear"), aniversaryDataGroup.getaYear());
    }

    public void fillBirthdayInfo(BirthdayData BirthdayData) {
        selectDropdownValue(By.name("bday"), BirthdayData.getbDay());
        selectDropdownValue(By.name("bmonth"), BirthdayData.getbMonth());
        type(By.name("byear"), BirthdayData.getbYear());
    }

    public void fillHomePage(String homePageAddress) {
        type(By.name("homepage"), homePageAddress);
    }

    public void fillEmails(EmailsData EmailsData) {
        type(By.name("email"), EmailsData.getEmail_1());
        type(By.name("email2"), EmailsData.getEmail_2());
        type(By.name("email3"), EmailsData.getEmail_3());
    }

    public void fillPhones(PhonesData PhonesData) {
        type(By.name("home"), PhonesData.getHomePhone());
        type(By.name("mobile"), PhonesData.getMobilePhone());
        type(By.name("work"), PhonesData.getWorkPhone());
        type(By.name("fax"), PhonesData.getFax());
        type(By.name("phone2"), PhonesData.getPhone2());
    }

    public void fillAddressInf(AddressData AddressData) {
        type(By.name("address"), AddressData.getAddressFirst());
        type(By.name("address2"), AddressData.getAdressSecond());
    }

    public void fillCompanyName(String companyName) {
        type(By.name("company"), companyName);
    }

    public void addTitle(String title) {
        type(By.name("title"), title);
    }

    public void submitNewContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }
}
