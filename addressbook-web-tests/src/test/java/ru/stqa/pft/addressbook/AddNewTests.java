package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AddNewTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
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

    @Test
    public void testUntitledTestCase() throws Exception {
        goToAddNewPage();
        fillFirstName("Aleksandra");
        fillMiddleName("n/a");
        fillLastName("Pancheshenko");
        fillNickName("n/a");
        addTitle("testTitle");
        fillCompanyName("testCompany");
        fillAddressInf(new addressessGroup("Poland", "Poland"));
        fillPhones(new phonesGroup("111", "222", "333", "444", "555"));
        fillEmails(new emailsGroup("pancheshenko.alex@gmail.com", "pancheshenkoalex@gmail.com", "pancheshenkoa.lex@gmail.com"));
        fillHomePage("n/a");
        fillBirthdayInfo(new birthdayGroup("28", "JULY", "1988"));
        fillAniversaryInfo(new aniversaryDataGroup("1", "JANUARY", "1988"));
        addGroup("Group_1");
        addNotes("n/a");
        submitForm();

    }

    private void submitForm() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void addNotes(String notes) {
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notes);
    }

    private void addGroup(String group) {
        wd.findElement(By.name("new_group")).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(group);
        wd.findElement(By.name("new_group")).click();
    }

    private void fillAniversaryInfo(aniversaryDataGroup aniversaryDataGroup) {
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

    private void fillBirthdayInfo(birthdayGroup birthdayGroup) {
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(birthdayGroup.getbDay());
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(birthdayGroup.getbMonth());
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(birthdayGroup.getbYear());
    }

    private void fillHomePage(String homePageAddress) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homePageAddress);
    }

    private void fillEmails(emailsGroup emailsGroup) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emailsGroup.getEmail_1());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(emailsGroup.getEmail_2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(emailsGroup.getEmail_3());
    }

    private void fillPhones(phonesGroup phonesGroup) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(phonesGroup.getHomePhone());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(phonesGroup.getMobilePhone());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(phonesGroup.getWorkPhone());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(phonesGroup.getFax());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(phonesGroup.getPhone2());
    }

    private void fillAddressInf(addressessGroup addressessGroup) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(addressessGroup.getAddressFist());
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(addressessGroup.getAdressSecond());
    }

    private void fillCompanyName(String companyName) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyName);
    }

    private void addTitle(String title) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
    }


    private void fillNickName(String nickName) {
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickName);
    }

    private void fillLastName(String lastName) {
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastName);
    }

    private void fillMiddleName(String middleName) {
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middleName);
    }

    private void fillFirstName(String name) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(name);
    }

    private void goToAddNewPage() {
        wd.findElement(By.xpath("//a[contains(text(),'ADD_NEW')]")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
