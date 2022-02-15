package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactsDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1", "test1"), true);
        }
    }
    @Test
    public void testContactsDeletion() throws Exception {
        List<ContactsData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactsData> after = app.contact().list();
        assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        assertEquals(before, after);

    }


}
