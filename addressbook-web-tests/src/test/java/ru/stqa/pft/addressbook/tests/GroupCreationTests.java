package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        application.getNavigationHelper().goToGroupPage();
        application.getGroupHelper().initiateGroupCreation();
        application.getGroupHelper().fillGroupForm(new GroupData("Group_1", null,null));
        application.getGroupHelper().submitGroupForm();
        application.getGroupHelper().returnToGroupPage();
    }


}
