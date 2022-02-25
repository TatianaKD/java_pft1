package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsAllInfoTests extends TestBase {
    @Test
    public void testContactInfo() {
        app.goTo().homePage();
        ContactsData contact = app.contact().all().iterator().next();
        ContactsData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        assertThat(mergeAllInfo(contactInfoFromDetailsForm), equalTo(mergeInfo(contact)));
    }

    private String mergeInfo(ContactsData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAllAddress(),
                        contact.getAllPhones(), contact.getAllEmails())
                .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

    }

    private String mergeAllInfo(ContactsData contact) {
        return Arrays.asList(contact.getAllInfoo())
                .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));


    }
}
