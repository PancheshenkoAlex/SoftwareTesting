package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {


        application.getNavigationHelper().goToGroupPage();
        int before = application.getGroupHelper().getGroupCount();
        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }
        application.getGroupHelper().selectGroup(before - 1);
        application.getGroupHelper().initGroupModification();
        application.getGroupHelper().fillGroupForm(new GroupData("Group_1", "test", "test"));
        application.getGroupHelper().submitModifiedForm();
        application.getGroupHelper().returnToGroupPage();
        int after = application.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
    }
}
