package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactsModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactsData()
                    .withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactsModification() throws Exception {
        Set<ContactsData> before = app.contact().all();
        ContactsData modifiedContact = before.iterator().next();
        ContactsData contact = new ContactsData().withId(modifiedContact.getId()).withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1");
        app.contact().modify(contact);
        Set<ContactsData> after = app.contact().all();
        assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        assertEquals(before, after);
    }


}
