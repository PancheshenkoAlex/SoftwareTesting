package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.getNavigationHelper().goToHomePage();
        List<ContactData> before = application.getContactHelper().getContactList();
        application.getNavigationHelper().goToAddNewPage();
        application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
        application.getNavigationHelper().goToHomePage();
        List<ContactData> after = application.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
