package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {
        application.getNavigationHelper().goToGroupPage();
        application.getGroupHelper().selectFirstGroup();
        application.getGroupHelper().deleteGroup();
        application.getGroupHelper().returnToGroupPage();
    }

}