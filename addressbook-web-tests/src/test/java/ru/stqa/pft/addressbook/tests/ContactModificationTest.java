package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.AniversaryData;
import ru.stqa.pft.addressbook.model.PersonalData;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {
        application.getNavigationHelper().goToHomePage();
        application.getContactHelper().clickEditButton();
        application.getContactHelper().fillPersonalData(new PersonalData("modifiedName", "modified", " ", " "));
        application.getContactHelper().fillAddressInf(new AddressData("Odessa", "Odessa"));
        application.getContactHelper().fillAniversaryInfo(new AniversaryData("1", "July", "2000"));
        application.getContactHelper().clickUpdateButton();


    }
}

