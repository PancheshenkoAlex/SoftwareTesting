package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();

        if (app.group().list().size() == 0) {
            app.group().createNew(new GroupData("Group_1", null, null));
        }

    }

    @Test
    public void testGroupModification() {

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData groupData = new GroupData(before.get(index).getId(), "Group_1", "test", "test");

        app.group().modify(index, groupData);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(groupData);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
