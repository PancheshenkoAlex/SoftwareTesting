package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.getNavigationHelper().goToAddNewPage();
        application.getContactHelper().fillPersonalData(new PersonalData("Aleksandra", "n/a", "Pancheshenko", "n/a"));
        application.getContactHelper().addTitle("testTitle");
        application.getContactHelper().fillCompanyName("testCompany");
        application.getContactHelper().fillAddressInf(new AddressData("Poland", "Poland"));
        application.getContactHelper().fillPhones(new PhonesData("111", "222", "333", "444", "555"));
        application.getContactHelper().fillEmails(new EmailsData("pancheshenko.alex@gmail.com", "pancheshenkoalex@gmail.com", "pancheshenkoa.lex@gmail.com"));
        application.getContactHelper().fillHomePage("n/a");
        application.getContactHelper().fillBirthdayInfo(new BirthdayData("28", "JULY", "1988"));
        application.getContactHelper().fillAniversaryInfo(new AniversaryData("1", "JANUARY", "1988"));
        application.getContactHelper().addGroup("Group_1");
        application.getContactHelper().addNotes("n/a");
        application.getContactHelper().submitNewContactForm();

    }


}
