package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.*;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        login("admin", "secret");
    }

    private void login(String loginName, String pass) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(loginName);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(pass);
        wd.findElement(By.xpath("//input[@value='LOGIN']")).click();
    }

    public void fillPersonalData(PersonalData personalData) {
        fillFirstName(personalData.getName());
        fillMiddleName(personalData.getMiddleName());
        fillLastName(personalData.getLstName());
        fillNickName(personalData.getNickName());
    }

    public void submitForm() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void addNotes(String notes) {
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notes);
    }

    public void addGroup(String group) {
        wd.findElement(By.name("new_group")).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(group);
        wd.findElement(By.name("new_group")).click();
    }

    public void fillAniversaryInfo(AniversaryData aniversaryDataGroup) {
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(aniversaryDataGroup.getaDay());
        wd.findElement(By.name("aday")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(aniversaryDataGroup.getaMonth());
        wd.findElement(By.name("amonth")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(aniversaryDataGroup.getaYear());
    }

    public void fillBirthdayInfo(BirthdayData BirthdayData) {
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(BirthdayData.getbDay());
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(BirthdayData.getbMonth());
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(BirthdayData.getbYear());
    }

    public void fillHomePage(String homePageAddress) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homePageAddress);
    }

    public void fillEmails(EmailsData EmailsData) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(EmailsData.getEmail_1());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(EmailsData.getEmail_2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(EmailsData.getEmail_3());
    }

    public void fillPhones(PhonesData PhonesData) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(PhonesData.getHomePhone());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(PhonesData.getMobilePhone());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(PhonesData.getWorkPhone());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(PhonesData.getFax());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(PhonesData.getPhone2());
    }

    public void fillAddressInf(AddressData AddressData) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(AddressData.getAddressFist());
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(AddressData.getAdressSecond());
    }

    public void fillCompanyName(String companyName) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyName);
    }

    public void addTitle(String title) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
    }

    public void fillNickName(String nickName) {
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickName);
    }

    public void fillLastName(String lastName) {
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastName);
    }

    public void fillMiddleName(String middleName) {
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middleName);
    }

    public void fillFirstName(String name) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(name);
    }

    public void goToAddNewPage() {
        wd.findElement(By.xpath("//a[contains(text(),'ADD_NEW')]")).click();

    }

    public void exit() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupForm() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    }

    public void initiateGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("GROUPS")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectFirstGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
