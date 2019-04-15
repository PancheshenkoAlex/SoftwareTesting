package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        application.getNavigationHelper().goToGroupPage();
    }

    @Test
    public void testGroupCreation() throws Exception {

        List<GroupData> before = application.getGroupHelper().getGroupList();
        GroupData groupData = new GroupData("Group_1", null, null);
        application.getGroupHelper().createGroup(groupData);
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        groupData.setID(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(groupData);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
