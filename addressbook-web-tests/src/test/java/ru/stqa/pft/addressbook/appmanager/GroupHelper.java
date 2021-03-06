package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initiateGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }


    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

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

    public void createNew(GroupData group) {
        initiateGroupCreation();
        fillGroupForm(group);
        submitGroupForm();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitModifiedForm();
        returnToGroupPage();
    }


    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        returnToGroupPage();
    }


    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withGroupName(name));
        }
        return groups;
    }


}
