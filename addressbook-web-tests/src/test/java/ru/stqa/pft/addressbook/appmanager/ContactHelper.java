package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fillContactData(ContactData contactData, boolean isItCreation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLstName());
        type(By.name("email"), contactData.getEmail_1());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("address"), contactData.getAddressFirst());
        if (isItCreation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void submitNewContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void selectFirstContact() {
        click(By.name("selected[]"));
    }

    public void clickRemoveButton() {
        click(By.xpath("//input[@value = 'DELETE']"));
        wd.switchTo().alert().accept();
    }


    public void selectAllRecords() {
        click(By.id("MassCB"));
    }

    public void clickEditButton() {
        click(By.xpath("//img[@title = 'EDIT']"));
    }

    public void clickUpdateButton() {
        click(By.xpath("//input[@value = 'UPDATE']"));
    }

    public void clickDeleteWhileModification() {
        click(By.xpath("//input[@value = 'DELETE']"));

    }
}
