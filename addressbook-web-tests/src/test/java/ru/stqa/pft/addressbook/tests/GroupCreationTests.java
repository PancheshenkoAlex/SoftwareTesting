package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        application.goToGroupPage();
        application.initiateGroupCreation();
        application.fillGroupForm(new GroupData("Group_1", "test", "test"));
        application.submitGroupForm();
        application.returnToGroupPage();
    }


}
