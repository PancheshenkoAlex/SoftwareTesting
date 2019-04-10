package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        application.getNavigationHelper().goToGroupPage();
        List<GroupData> before = application.getGroupHelper().getGroupList();
        application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
