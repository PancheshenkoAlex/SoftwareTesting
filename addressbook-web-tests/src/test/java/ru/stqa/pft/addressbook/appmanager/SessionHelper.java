package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void login(String loginName, String pass) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(loginName);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(pass);
        wd.findElement(By.xpath("//input[@value='LOGIN']")).click();
    }

}
