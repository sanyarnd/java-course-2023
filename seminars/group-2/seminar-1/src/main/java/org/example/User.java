package org.example;

import java.util.Arrays;

public class User {

    private long id;
    private String login;
    private String tgAddress;
    private String mailAddress;
    private String[] allowCountries;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTgAddress() {
        return tgAddress;
    }

    public void setTgAddress(String tgAddress) {
        this.tgAddress = tgAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String[] getAllowCountries() {
        return allowCountries;
    }

    public void setAllowCountries(String[] allowCountries) {
        this.allowCountries = allowCountries;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", login='" + login + '\'' +
               ", tgAddress='" + tgAddress + '\'' +
               ", mailAddress='" + mailAddress + '\'' +
               ", allowCountries=" + Arrays.toString(allowCountries) +
               '}';
    }
}
