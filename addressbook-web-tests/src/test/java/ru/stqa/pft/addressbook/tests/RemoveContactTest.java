package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class RemoveContactTest extends TestBase {
    @Test
    public void testRemoveContact() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }
        application.getContactHelper().selectFirstContact();
        application.getContactHelper().clickRemoveButton();

    }

    @Test
    public void testRemoveContactWhileModification() {
        application.getNavigationHelper().goToHomePage();
        if (!application.getContactHelper().isThereAContact()) {
            application.getNavigationHelper().goToAddNewPage();
            application.getContactHelper().createContact(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            application.getNavigationHelper().goToHomePage();
        }

        application.getContactHelper().clickEditButton();
        application.getContactHelper().clickDeleteWhileModification();
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
