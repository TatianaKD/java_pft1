package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

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
        Set<ContactsData> before = app.contact().all();
        ContactsData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactsData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        assertEquals(before, after);

    }


}
