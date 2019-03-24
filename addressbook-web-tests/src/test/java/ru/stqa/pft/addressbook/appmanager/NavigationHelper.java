package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddNewPage() {
        click(By.xpath("//a[contains(text(),'ADD_NEW')]"));

    }

    public void goToGroupPage() {

        if (isElementPresent(By.tagName("h1"))
                && (wd.findElement(By.tagName("h1")).getText().equals("GROUPS"))
                && (isElementPresent(By.name("new")))) {
            return;
        }

        click(By.linkText("GROUPS"));

    }

    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("HOME"));
    }
}
