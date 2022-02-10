package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectContacts(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }


    public void initContactsModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactsModification() {
        click(By.name("update"));
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactsData contacts, boolean b) {
        goToContactsPage();
        fillContactForm(contacts, b);
        submitContactsCreation();
        returnToContactsPage();

    }

    public void goToContactsPage() {
        click(By.linkText("add new"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactsData> getContactList() {
        List<ContactsData> contacts = new ArrayList<ContactsData>();
        WebElement elements = wd.findElement(By.cssSelector("table#maintable"));
        List<WebElement> trElements = elements.findElements(By.tagName("tr"));

        for (WebElement trElement : trElements) {
            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
            if(tdElements.size()==0){
                continue;
            }
            String lastname = tdElements.get(1).getText();
            String firstname = tdElements.get(2).getText();
            ContactsData contact = new ContactsData(firstname, null,lastname , null, null);
            contacts.add(contact);
        }

        return contacts;
    }
}





