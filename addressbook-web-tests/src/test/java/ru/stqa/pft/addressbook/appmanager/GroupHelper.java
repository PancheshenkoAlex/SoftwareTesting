package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initiateGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitModifiedForm() {
        click(By.name("update"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));

    }

    public void createGroup(GroupData group) {
        initiateGroupCreation();
        fillGroupForm(group);
        submitGroupForm();
        returnToGroupPage();
    }

    public void modifyGroup(int index, GroupData groupData) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(groupData);
        submitModifiedForm();
        returnToGroupPage();
    }

    public void deleteSelectedGroup(int index) {
        selectGroup(index);
        deleteGroup();
        returnToGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
