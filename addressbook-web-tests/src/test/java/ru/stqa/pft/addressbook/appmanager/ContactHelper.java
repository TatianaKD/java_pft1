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


    public void fillGroupForm(ContactsData kontactsData) {
        type(By.name("firstname"), kontactsData.getFirstname());
        type(By.name("middlename"), kontactsData.getMiddlename());
        type(By.name("lastname"), kontactsData.getLastname());
        type(By.name("nickname"), kontactsData.getNickname());

    }
    public void submitContactsCreation() {
        click(By.xpath("//input[21]"));

    }

}

