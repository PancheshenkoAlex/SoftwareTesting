package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {


        application.getNavigationHelper().goToGroupPage();
        application.getGroupHelper().selectFirstGroup();
        application.getGroupHelper().initGroupModification();
        application.getGroupHelper().fillGroupForm(new GroupData("Group_1", "test", "test"));
        application.getGroupHelper().submitModifiedForm();
        application.getGroupHelper().returnToGroupPage();
    }
}
