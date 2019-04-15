package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;

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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public void createNew(ContactData contact, boolean b) {

        fillContactData(contact, b);
        submitNewContactForm();
    }

    public void modify(ContactData contact) {
        clickEditButton();
        fillContactData(contact, false);
        clickUpdateButton();
        returnToHomePage();
    }

    public void removeSelected(int index) {
        selectContact(index);
        clickRemoveButton();
        returnToHomePage();
    }
    private void returnToHomePage() {
        click(By.linkText("HOME"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@title = 'EDIT']"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1");
            contacts.add(contact);
        }
        return contacts;
    }
}
