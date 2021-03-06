package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
    }

    @Test
    public void testGroupCreation() throws Exception {

        Groups before = app.group().all();
        GroupData group = new GroupData().withGroupName("Group_1");
        app.group().createNew(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before
                .withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
