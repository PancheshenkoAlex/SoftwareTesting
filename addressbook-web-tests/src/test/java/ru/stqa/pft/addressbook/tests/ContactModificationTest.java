package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        if (app.contact().list().size() == 0) {
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
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
                .withFirstname("Aleks")
                .withLastname("Panch")
                .withAddressFirst("Poland")
                .withPhoneHome("111")
                .withEmail("p@ya.ru");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }


}


