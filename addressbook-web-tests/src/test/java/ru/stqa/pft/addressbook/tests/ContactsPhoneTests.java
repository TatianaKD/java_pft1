package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsPhoneTests extends TestBase {
    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactsData contact = app.contact().all().iterator().next();
        ContactsData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));
        assertThat(contact.getAllAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(ContactsData contact) {
        return Arrays.asList(contact.getAddress()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    }

    private String mergeEmail(ContactsData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmailTwo(), contact.getEmailThree())
                .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactsData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals("")).map(ContactsPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
