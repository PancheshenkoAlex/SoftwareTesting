package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void AddNewContactTest() throws Exception {
        application.getNavigationHelper().goToHomePage();
        List<ContactData> before = application.getContactHelper().getContactList();
        application.getNavigationHelper().goToAddNewPage();
        ContactData contact = new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1");
        application.getContactHelper().createContact(contact, true);
        application.getNavigationHelper().goToHomePage();
        List<ContactData> after = application.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
