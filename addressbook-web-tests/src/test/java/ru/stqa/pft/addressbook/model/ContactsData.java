package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactsData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String AllPhones;
    private String email;
    private String emailTwo;
    private String emailThree;
    private String AllEmails;
    private String AllAddress;
    private String address;
    private String allInfo;
    private String allInfoo;

    public String getAllInfoo() {
        return allInfoo;
    }

    public ContactsData withAllInfoo(String allInfoo) {
        this.allInfoo = allInfoo;
        return this;
    }

    public String getAllInfo() {
        return allInfo;
    }

    public ContactsData withAllInfo(String allInfo) {
        this.allInfo = allInfo;
        return this;
    }

    public String getAllAddress() {
        return AllAddress;
    }

    public ContactsData withAllAddress(String allAddress) {
        this.AllAddress = allAddress;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactsData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactsData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmailTwo() {
        return emailTwo;
    }

    public ContactsData withEmailTwo(String emailTwo) {
        this.emailTwo = emailTwo;
        return this;
    }

    public String getEmailThree() {
        return emailThree;
    }

    public ContactsData withEmailThree(String emailThree) {
        this.emailThree = emailThree;
        return this;
    }

    public String getAllEmails() {
        return AllEmails;
    }

    public ContactsData withAllEmails(String AllEmails) {
        this.AllEmails = AllEmails;
        return this;
    }

    public String getAllPhones() {
        return AllPhones;
    }
    public ContactsData withAllPhones(String AllPhones) {
        this.AllPhones = AllPhones;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactsData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactsData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }


    public ContactsData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

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
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}

