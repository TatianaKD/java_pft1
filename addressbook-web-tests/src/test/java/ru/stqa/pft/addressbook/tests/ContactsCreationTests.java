package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<ContactsData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1", "test1"), true);
        List<ContactsData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
