package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {


        application.getNavigationHelper().goToGroupPage();

        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }

        List<GroupData> before = application.getGroupHelper().getGroupList();
        application.getGroupHelper().selectGroup(before.size() - 1);
        application.getGroupHelper().initGroupModification();
        GroupData groupData = new GroupData(before.get(before.size() - 1).getId(),"Group_1", "test", "test");
        application.getGroupHelper().fillGroupForm(groupData);
        application.getGroupHelper().submitModifiedForm();
        application.getGroupHelper().returnToGroupPage();
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(groupData);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
