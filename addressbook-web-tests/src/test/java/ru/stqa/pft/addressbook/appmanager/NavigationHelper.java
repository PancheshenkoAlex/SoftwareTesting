package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void goToAddNewPage() {
        wd.findElement(By.xpath("//a[contains(text(),'ADD_NEW')]")).click();

    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("GROUPS")).click();
    }
}
