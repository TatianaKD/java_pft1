package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactsModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactsData()
                    .withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactsModification() throws Exception {
        List<ContactsData> before = app.contact().list();
        int index = before.size() - 1;
        ContactsData contact = new ContactsData().withId(before.get(index).getId()).withFirstname("firstname1").withMiddlename("middlename1").withLastname("lastname1").withNickname("nickname 1");
        app.contact().modify(index, contact);
        List<ContactsData> after = app.contact().list();
        assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(before, after);
    }


}
