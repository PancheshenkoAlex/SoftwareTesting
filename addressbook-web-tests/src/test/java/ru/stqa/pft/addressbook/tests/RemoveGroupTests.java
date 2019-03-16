package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {
        application.goToGroupPage();
        application.selectFirstGroup();
        application.deleteGroup();
        application.returnToGroupPage();
    }

}