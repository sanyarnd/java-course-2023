package org.example;

public class UserSingleReader implements UserReader {

    @Override
    public User readUser() {
        User user = new User();
        user.setId(-10);
        user.setLogin("defaultUser");
        user.setTgAddress("@default");
        user.setMailAddress("default@tinkoff.ru");
        user.setAllowCountries(new String[] {"china"});
        return user;
    }

}
