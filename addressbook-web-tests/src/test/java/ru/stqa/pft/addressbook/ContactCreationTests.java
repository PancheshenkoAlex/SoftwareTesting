package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        goToAddNewPage();
        fillPersonalData(new PersonalData("Aleksandra", "n/a", "Pancheshenko", "n/a"));
        addTitle("testTitle");
        fillCompanyName("testCompany");
        fillAddressInf(new AddressData("Poland", "Poland"));
        fillPhones(new PhonesData("111", "222", "333", "444", "555"));
        fillEmails(new EmailsData("pancheshenko.alex@gmail.com", "pancheshenkoalex@gmail.com", "pancheshenkoa.lex@gmail.com"));
        fillHomePage("n/a");
        fillBirthdayInfo(new BirthdayData("28", "JULY", "1988"));
        fillAniversaryInfo(new AniversaryData("1", "JANUARY", "1988"));
        addGroup("Group_1");
        addNotes("n/a");
        submitForm();

    }


}
