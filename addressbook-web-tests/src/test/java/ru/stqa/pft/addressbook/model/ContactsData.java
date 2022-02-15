package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactsData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String group;

    public ContactsData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactsData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactsData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactsData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactsData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactsData withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
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

    public String getNickname() {
        return nickname;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactsData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsData that = (ContactsData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}

