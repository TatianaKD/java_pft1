package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;
import java.util.stream.Collectors;

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

    public void selectContactsById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }


    public void initContactsModification(int id) {
        click((By.cssSelector("#maintable tr:last-child td:nth-child(8) a")));

    }

    private void initContactsDetails(int id) {
        click((By.cssSelector("#maintable tr:last-child td:nth-child(7) a ")));
    }

    public void submitContactsModification() {
        click(By.name("update"));
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactsData contacts, boolean b) {
        goToContactsPage();
        fillContactForm(contacts, b);
        submitContactsCreation();
        contactCache = null;
        returnToContactsPage();

    }

    public void modify(ContactsData contact) {
        selectContactsById(contact.getId());
        initContactsModification(contact.getId());
        fillContactForm(contact, false);
        submitContactsModification();
        contactCache = null;
        returnToContactsPage();
    }

    public void delete(ContactsData contact) {
        selectContactsById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
        returnToContactsPage();
    }

    public void goToContactsPage() {
        click(By.linkText("add new"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        WebElement elements = wd.findElement(By.cssSelector("table#maintable"));
        List<WebElement> trElements = elements.findElements(By.tagName("tr"));

        for (WebElement trElement : trElements) {
            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
            if (tdElements.size() == 0) {
                continue;
            }
            String lastname = tdElements.get(1).getText();
            String firstname = tdElements.get(2).getText();
            String allPhones = tdElements.get(5).getText();
            String allEmails = tdElements.get(4).findElements(By.cssSelector("a")).stream()
                    .map(WebElement::getText).collect(Collectors.joining("\n"));
            String allAddress = tdElements.get(3).getText();
            int id = Integer.parseInt(tdElements.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactsData contact = new ContactsData().
                    withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAllAddress(allAddress);
            contactCache.add(contact);
        }

        return new Contacts(contactCache);
    }


    public ContactsData infoFromEditForm(ContactsData contact) {
        initContactsModification(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String emailTwo = wd.findElement(By.name("email2")).getAttribute("value");
        String emailThree = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactsData().
                withId(contact.getId()).withFirstname(firstname).
                withLastname(lastname).withHomePhone(home).
                withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmailTwo(emailTwo).
                withEmailThree(emailThree).withAddress(address);
    }

    public ContactsData infoFromDetailsForm(ContactsData contact) {
        initContactsDetails(contact.getId());
        String allInfo = wd.findElement(By.id("content")).getText();
        String allInfoo = cleaned(allInfo);
        return new ContactsData().withId(contact.getId()).withAllInfoo(allInfoo);

    }
    public static String cleaned(String allInfo) {
        return allInfo.replaceAll("\\s+", " ").replaceAll("[-()]|H:|W:|\n", "")
                .replaceAll("\\s+","\n");
    }



}





