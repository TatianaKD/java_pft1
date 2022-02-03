package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.awt.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactsPage() {
        click(By.linkText("home"));
    }


    public void fillContactForm(ContactsData contactsData, boolean creation) {
        type(By.name("firstname"), contactsData.getFirstname());
        type(By.name("middlename"), contactsData.getMiddlename());
        type(By.name("lastname"), contactsData.getLastname());
        type(By.name("nickname"), contactsData.getNickname());
//контролируем наличие элемента с выпадающим списком
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitContactsCreation() {
        click(By.xpath("//input[21]"));

    }
    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void selectContacts() {
        click(By.xpath("//input[@id='9']"));
    }


    public void initContactsModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactsModification() {
        click(By.xpath("//input[22]"));
    }
}

