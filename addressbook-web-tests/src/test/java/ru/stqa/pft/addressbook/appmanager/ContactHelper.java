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

    public void clickEditButton(int index) {
        wd.findElements(By.xpath("//img[@title = 'EDIT']")).get(index).click();
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

    public void modify(int index, ContactData contact) {
        clickEditButton(index);
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
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String phoneHome = cells.get(5).getText();
            String email = cells.get(4).getText();


            contacts.add(new ContactData()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddressFirst(address)
                    .withPhoneHome(phoneHome)
                    .withEmail(email)
                    .withGroup("Group_1"));
        }
        return contacts;
    }
}
