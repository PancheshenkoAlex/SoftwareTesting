package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        goToGroupPage();
        initiateGroupCreation();
        fillGroupForm(new GroupData("Group_1", "test", "test"));
        submitGroupForm();
        returnToGroupPage();
    }


}
