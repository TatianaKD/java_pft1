package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactsData contact = new ContactsData()
                .withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
    @Test
    public void testBadContactsCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactsData contact = new ContactsData()
                .withFirstname("firstname1'").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
}
