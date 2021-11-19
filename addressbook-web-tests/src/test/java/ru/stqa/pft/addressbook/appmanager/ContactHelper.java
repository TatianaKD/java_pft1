package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactsPage() {
        click(By.linkText("home"));
    }


    public void fillContactForm(ContactsData contactsData) {
        type(By.name("firstname"), contactsData.getFirstname());
        type(By.name("middlename"), contactsData.getMiddlename());
        type(By.name("lastname"), contactsData.getLastname());
        type(By.name("nickname"), contactsData.getNickname());
//если найдет строчку, чтобы выбрать элемент, то заполнит ее, если нет, то пропустит
        if(isElementPresent(By.name("new_group"))) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());
        }
    }

    public void submitContactsCreation() {
        click(By.xpath("//input[21]"));

    }

    public void initContactsModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactsModification() {
        click(By.xpath("//input[22]"));
    }
}

