package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void logIn(String login, String password) {
        type(By.name("user"), login);
        click(By.id("LoginForm"));
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}
