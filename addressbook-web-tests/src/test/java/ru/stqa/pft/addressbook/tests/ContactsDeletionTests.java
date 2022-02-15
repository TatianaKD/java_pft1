package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactsDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactsData()
                    .withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactsDeletion() throws Exception {
        List<ContactsData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactsData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        assertEquals(before, after);

    }


}
