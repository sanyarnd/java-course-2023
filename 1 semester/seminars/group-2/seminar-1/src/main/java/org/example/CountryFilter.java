package org.example;

public class CountryFilter implements MessageFilter {

    private static final boolean COUNTRY_FILTER_ENABLE = true;

    private final UserStorage userStorage;

    public CountryFilter(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public boolean filter(Message message) {
        if (!COUNTRY_FILTER_ENABLE) {
            return true;
        }
        User user = userStorage.getUser(message.getToUserId());
        for (var country : user.getAllowCountries()) {
            if (message.getFrom().equals(country)) {
                return true;
            }
        }
        return false;
    }
}
