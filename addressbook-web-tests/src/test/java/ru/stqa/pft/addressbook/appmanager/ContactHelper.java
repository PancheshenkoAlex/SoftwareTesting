package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;
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


    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }

    public void clickRemoveButton() {
        click(By.xpath("//input[@value = 'DELETE']"));
        wd.switchTo().alert().accept();
    }


    public void clickEditButtonById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).findElement(By.xpath("//img[@title = 'EDIT']")).click();

    }

    public void clickUpdateButton() {
        click(By.xpath("//input[@value = 'UPDATE']"));
    }


    public void createNew(ContactData contact, boolean b) {

        fillContactData(contact, b);
        submitNewContactForm();
    }

    public void modify(ContactData contact) {
        clickEditButtonById(contact.getId());
        fillContactData(contact, false);
        clickUpdateButton();
        returnToHomePage();
    }


    public void removeSelected(ContactData contact) {
        selectContactById(contact.getId());
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

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String phoneHome = cells.get(5).getText();
            String email = cells.get(4).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData()
                    .withId(id)
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

