package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {


    protected static final ApplicationManager application = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        application.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        application.exit();

    }

}
