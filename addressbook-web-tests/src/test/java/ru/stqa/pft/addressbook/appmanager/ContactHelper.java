package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactsPage() {
        click(By.linkText("add new"));
    }


    public void fillContactForm(ContactsData contactsData) {
        type(By.name("firstname"), contactsData.getFirstname());
        type(By.name("middlename"), contactsData.getMiddlename());
        type(By.name("lastname"), contactsData.getLastname());
        type(By.name("nickname"), contactsData.getNickname());

    }
    public void submitContactsCreation() {
        click(By.xpath("//input[21]"));

    }

}

