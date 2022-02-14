package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactsDeletionTests extends TestBase {
    @Test
    public void testContactsDeletion() throws Exception {
        app.getNavigationHelper().goToHomePage();
        //Если нет контакта, то прежде чем удалить создай
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1", "test1"), true);
        }
        List<ContactsData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContacts(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().returnToContactsPage();
        List<ContactsData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
