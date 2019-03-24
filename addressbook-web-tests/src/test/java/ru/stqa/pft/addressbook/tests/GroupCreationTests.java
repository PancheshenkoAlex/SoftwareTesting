package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        application.getNavigationHelper().goToGroupPage();
        application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
    }


}
