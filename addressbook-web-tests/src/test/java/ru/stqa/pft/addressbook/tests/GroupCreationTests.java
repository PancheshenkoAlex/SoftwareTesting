package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {
        application.getNavigationHelper().goToGroupPage();
        List<GroupData> before = application.getGroupHelper().getGroupList();
        GroupData groupData = new GroupData("Group_1", null, null);
        application.getGroupHelper().createGroup(groupData);
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        groupData.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(groupData);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }


}
