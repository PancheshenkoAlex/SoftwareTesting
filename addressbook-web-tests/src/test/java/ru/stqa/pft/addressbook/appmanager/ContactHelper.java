package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fillContactData(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLstName());
        type(By.name("email"), contactData.getEmail_1());
        type(By.name("email2"), contactData.getEmail_2());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("address"), contactData.getAddressFirst());
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
