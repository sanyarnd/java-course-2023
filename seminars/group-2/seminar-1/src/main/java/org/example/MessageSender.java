package org.example;

public class MessageSender {

    private final UserStorage userStorage;
    private final MessageFilter[] messageFilters;

    public MessageSender(UserStorage userStorage, MessageFilter[] messageFilters) {
        this.userStorage = userStorage;
        this.messageFilters = messageFilters;
    }

    public void sendMessage(Message message) {
        for (MessageFilter filter : messageFilters) {
            if (!filter.filter(message)) {
                System.out.println("Sorry! We can't send message");
                return;
            }
        }

        User user = userStorage.getUser(message.getToUserId());
        for (var messanger : message.getDestinations()) {
            switch (messanger) {
                case "tg" -> System.out.printf("TG:\nfrom = %s\nmessage = %s\ntoUser = %s\n", message.getFrom(),
                    message.getBody(),
                    user.getTgAddress());
                case "mail" -> System.out.printf("Mail:\n This mail from %s, hello %s\n%s\n", message.getFrom(),
                    user.getMailAddress(),
                    message.getBody());
            }
        }
    }

}
