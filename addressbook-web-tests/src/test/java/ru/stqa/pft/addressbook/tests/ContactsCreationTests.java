package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<ContactsData> before = app.getContactHelper().getContactList();
        ContactsData contact = new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1", "test1");
        app.getContactHelper().createContact(contact, true);
        List<ContactsData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        contact.setId(after.stream().max((Comparator<ContactsData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
