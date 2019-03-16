package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String loginName, String pass) {
        wd.get("http://localhost/addressbook/");
        type(By.name("user"), loginName);
        type(By.name("pass"), pass);
        click(By.xpath("//input[@value='LOGIN']"));
    }

}
