package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before = application.getContactHelper().getContactList();
        application.getContactHelper().clickEditButton();
        ContactData contact = new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", null);
        application.getContactHelper().fillContactData(contact, false);
        application.getContactHelper().clickUpdateButton();
        application.getNavigationHelper().goToHomePage();
        List<ContactData> after = application.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }


}


