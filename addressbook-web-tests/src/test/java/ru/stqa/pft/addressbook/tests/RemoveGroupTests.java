package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {

        application.getNavigationHelper().goToGroupPage();
        int before = application.getGroupHelper().getGroupCount();
        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }
        application.getGroupHelper().selectGroup(before - 1);
        application.getGroupHelper().deleteGroup();
        application.getGroupHelper().returnToGroupPage();
        int after = application.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }

}