package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class RemoveContactTest extends TestBase {
    @Test
    public void testRemoveContact() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before = application.getContactHelper().getContactList();
        application.getContactHelper().selectContact(before.size() - 1);
        application.getContactHelper().clickRemoveButton();
        application.getNavigationHelper().goToHomePage();
        List<ContactData> after = application.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

    @Test
    public void testRemoveContactWhileModification() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }
        List<ContactData> before = application.getContactHelper().getContactList();
        application.getContactHelper().clickEditButton();
        application.getContactHelper().clickDeleteWhileModification();
        application.getNavigationHelper().goToHomePage();
        List<ContactData> after = application.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        
        Assert.assertEquals(after.size(), before.size() - 1);
    }

    @Test
    public void testRemoveAllRecords() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }

        application.getContactHelper().selectAllRecords();
        application.getContactHelper().clickRemoveButton();

    }
}
