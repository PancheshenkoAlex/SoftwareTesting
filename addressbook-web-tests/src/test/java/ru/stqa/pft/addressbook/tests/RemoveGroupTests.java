package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Set;

public class RemoveGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();

        if (app.group().all().size() == 0) {
            app.group().createNew(new GroupData().withGroupName("Group_1"));
        }

    }

    @Test
    public void testRemoveGroup() throws Exception {

        Set<GroupData> before = app.group().all();
        GroupData deleteGroup = before.iterator().next();
        app.group().deleteSelected(deleteGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deleteGroup);
        Assert.assertEquals(before, after);

    }


}