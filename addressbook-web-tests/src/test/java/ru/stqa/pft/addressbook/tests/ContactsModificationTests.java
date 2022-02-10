package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsModificationTests extends TestBase{
    @Test
    public void testContactsModification() throws Exception {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1","test1"),true);
        }
        app.getContactHelper().selectContacts(before -1);
        app.getContactHelper().initContactsModification();
        app.getContactHelper().fillContactForm(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1",null),false);
        app.getContactHelper().submitContactsModification();
        app.getContactHelper().returnToContactsPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
