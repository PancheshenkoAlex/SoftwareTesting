package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class RemoveGroupTests extends TestBase {


    @Test
    public void testRemoveGroup() throws Exception {
        application.getNavigationHelper().goToGroupPage();
        if (!application.getGroupHelper().isThereAGroup()) {
            application.getGroupHelper().createGroup(new GroupData("Group_1", null, null));
        }
        application.getGroupHelper().selectFirstGroup();
        application.getGroupHelper().deleteGroup();
        application.getGroupHelper().returnToGroupPage();
    }

}