package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();

        if (app.group().all().size() == 0) {
            app.group().createNew(new GroupData().withGroupName("Group_1"));
        }

    }

    @Test
    public void testGroupModification() {

        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withGroupName("Group_1")
                .withGroupHeader("test")
                .withGroupFooter("test");

        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
