package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        if (app.contact().all().size() == 0) {
            app.goTo().AddNewPage();
            app.contact().createNew(new ContactData()
                    .withFirstname("Aleks")
                    .withLastname("Panch")
                    .withAddressFirst("Poland")
                    .withPhoneHome("111")
                    .withEmail("p@ya.ru")
                    .withGroup("Group_1"), true);
            app.goTo().HomePage();
        }
    }

    @Test
    public void testRemoveContact() {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().removeSelected(deletedContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));

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
