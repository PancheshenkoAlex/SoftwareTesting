package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {
        goToGroupPage();
        selectFirstGroup();
        deleteGroup();
        returnToGroupPage();
    }

}