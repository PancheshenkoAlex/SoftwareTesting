package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        if (app.contact().list().size() == 0) {
            app.goTo().AddNewPage();
            app.contact().createNew(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            app.goTo().HomePage();
        }
    }

    @Test
    public void testRemoveContact() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().removeSelected(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


/*
    @Test
    public void testRemoveContactWhileModification() {
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().AddNewPage();
            app.contact().createNew(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            app.goTo().HomePage();
        }
        List<ContactData> before = app.contact().list();
        app.contact().clickEditButton();
        app.contact().clickDeleteWhileModification();
        app.goTo().HomePage();
        List<ContactData> after = app.contact().list();
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        Assert.assertEquals(after.size(), before.size() - 1);
    }

    @Test
    public void testRemoveAllRecords() {
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().AddNewPage();
            app.contact().createNew(new ContactData("Aleks", "Panch", "Poland", "111", "p@ya.ru", "Group_1"), true);
            app.goTo().HomePage();
        }

        app.contact().selectAllRecords();
        app.contact().clickRemoveButton();

    }*/
}
