package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {


    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void selectDropdownValue(By locator, String dropdownValue) {
        wd.findElement(locator).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(dropdownValue);
        click(By.name("new_group"));
    }
}
