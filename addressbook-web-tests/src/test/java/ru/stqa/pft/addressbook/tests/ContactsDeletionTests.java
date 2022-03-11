package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import static org.hamcrest.CoreMatchers.equalTo;

public class ContactsDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactsData()
                    .withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactsDeletion() throws Exception {
        Contacts before = app.contact().all();
        ContactsData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        MatcherAssert.assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        MatcherAssert.assertThat(after, equalTo(before.withOut(deletedContact)));

    }


}
