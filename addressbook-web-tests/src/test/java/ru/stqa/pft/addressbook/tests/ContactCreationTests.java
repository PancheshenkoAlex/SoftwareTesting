package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
    }

    @Test
    public void AddNewContactTest() throws Exception {

        Contacts before = app.contact().all();
        app.goTo().AddNewPage();
        ContactData contact = new ContactData()
                .withFirstname("Aleks")
                .withLastname("Panch")
                .withAddressFirst("Poland")
                .withPhoneHome("111")
                .withEmail("p@ya.ru")
                .withGroup("Group_1");
        app.contact().createNew(contact, true);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
