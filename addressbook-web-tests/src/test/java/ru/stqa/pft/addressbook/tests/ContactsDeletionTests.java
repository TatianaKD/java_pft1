package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactsDeletionTests extends TestBase {
    @Test
    public void testContactsDeletion()throws Exception{
        app.getNavigationHelper().goToHomePage();
        //Если нет контакта, то прежде чем удалить создай
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactsData("firstname1", "middlename1", "lastname1", "nickname 1","test1"),true);
        }
        app.getContactHelper().selectContacts();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().returnToContactsPage();
    }
}
