package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class RemoveGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        application.getNavigationHelper().goToGroupPage();

        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }

    }

    @Test
    public void testRemoveGroup() throws Exception {

        List<GroupData> before = application.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        application.getGroupHelper().deleteSelectedGroup(index);
        List<GroupData> after = application.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }



}