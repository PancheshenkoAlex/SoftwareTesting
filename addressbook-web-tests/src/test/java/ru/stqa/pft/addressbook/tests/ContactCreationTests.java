package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.modules.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.goToAddNewPage();
        application.fillPersonalData(new PersonalData("Aleksandra", "n/a", "Pancheshenko", "n/a"));
        application.addTitle("testTitle");
        application.fillCompanyName("testCompany");
        application.fillAddressInf(new AddressData("Poland", "Poland"));
        application.fillPhones(new PhonesData("111", "222", "333", "444", "555"));
        application.fillEmails(new EmailsData("pancheshenko.alex@gmail.com", "pancheshenkoalex@gmail.com", "pancheshenkoa.lex@gmail.com"));
        application.fillHomePage("n/a");
        application.fillBirthdayInfo(new BirthdayData("28", "JULY", "1988"));
        application.fillAniversaryInfo(new AniversaryData("1", "JANUARY", "1988"));
        application.addGroup("Group_1");
        application.addNotes("n/a");
        application.submitForm();

    }


}
