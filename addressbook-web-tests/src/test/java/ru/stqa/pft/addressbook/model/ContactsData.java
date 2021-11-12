package ru.stqa.pft.addressbook.model;

public class ContactsData {
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;

    public ContactsData(String firstname, String middlename, String lastname, String nickname) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname(){ return nickname;}
}
