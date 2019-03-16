package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @Test
    public void testRemoveContact() {
        application.getNavigationHelper().goToHomePage();
        application.getContactHelper().selectFirstContact();
        application.getContactHelper().clickRemoveButton();

    }

    @Test
    public void testRemoveContactWhileModification(){
        application.getNavigationHelper().goToHomePage();
        application.getContactHelper().clickEditButton();
        application.getContactHelper().clickDeleteWhileModification();
    }
    @Test
    public void testRemoveAllRecords(){
        application.getNavigationHelper().goToHomePage();
        application.getContactHelper().selectAllRecords();
        application.getContactHelper().clickRemoveButton();

    }
}
