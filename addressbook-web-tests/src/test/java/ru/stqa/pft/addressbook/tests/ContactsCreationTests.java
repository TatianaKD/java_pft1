package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {

    @Test
    public void testContactsCreation() throws Exception {
        app.getNavigationHelper().goToContactsPage();
        app.getContactHelper().fillContactForm(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1","test1"),true);
        app.getContactHelper().submitContactsCreation();
        app.getContactHelper().returnToContactsPage();
    }
}
