package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactsModificationTests extends TestBase {
    @Test
    public void testContactsModification() throws Exception {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1", "test1"), true);
        }
        List<ContactsData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContacts(before.size() - 1);
        app.getContactHelper().initContactsModification();
        ContactsData contact = new ContactsData(before.get(before.size() - 1).getId(),"firstname1", "middlename1", "lastname1", "nickname 1", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactsModification();
        app.getContactHelper().returnToContactsPage();
        List<ContactsData> after = app.getContactHelper().getContactList();
        assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
