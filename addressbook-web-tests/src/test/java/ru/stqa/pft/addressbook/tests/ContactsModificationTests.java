package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsModificationTests extends TestBase{
    @Test
    public void ContactsCreationTests() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactsModification();
        app.getContactHelper().fillContactForm(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1",null));
        app.getContactHelper().submitContactsModification();
        app.getContactHelper().returnToContactsPage();
    }
}
