package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager application = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        application.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        application.exit();

    }

}
