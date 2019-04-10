package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        application.getNavigationHelper().goToGroupPage();
        int before = application.getGroupHelper().getGroupCount();
        application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        int after = application.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }


}
