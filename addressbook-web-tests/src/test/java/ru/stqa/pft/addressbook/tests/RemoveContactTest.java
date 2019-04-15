package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }
    }

    @Test
    public void testRemoveContact() {

        List<ContactData> before = application.getContactHelper().getContactList();
        int index = before.size() - 1;
        application.getContactHelper().removeSelectedContact(index);
        List<ContactData> after = application.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


/*
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

    }*/
}
