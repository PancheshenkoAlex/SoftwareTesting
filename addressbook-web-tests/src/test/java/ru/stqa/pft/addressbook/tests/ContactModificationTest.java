package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {
        application.getNavigationHelper().goToHomePage();
        application.getContactHelper().clickEditButton();
        application.getContactHelper().fillContactData(new ContactData("Aleks", "Panch", "Poland", "111", "222", "p@ya.ru", "p@ya.ru"));
        application.getContactHelper().clickUpdateButton();


    }
}

