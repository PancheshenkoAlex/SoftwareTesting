package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.getNavigationHelper().goToAddNewPage();
        application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);

    }


}
