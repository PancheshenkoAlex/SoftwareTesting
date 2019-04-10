package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {

        application.getNavigationHelper().goToGroupPage();

        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }

        List<GroupData> before = application.getGroupHelper().getGroupList();
        application.getGroupHelper().selectGroup(before.size() - 1);
        application.getGroupHelper().deleteGroup();
        application.getGroupHelper().returnToGroupPage();
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }

}