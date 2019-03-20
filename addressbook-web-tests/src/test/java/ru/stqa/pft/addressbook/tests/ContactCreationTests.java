package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.getNavigationHelper().goToAddNewPage();
        application.getContactHelper().fillContactData(new ContactData("Aleks", "Panch", "Poland", "111", "222", "p@ya.ru", "p@ya.ru"));
        application.getContactHelper().submitNewContactForm();

    }


}
