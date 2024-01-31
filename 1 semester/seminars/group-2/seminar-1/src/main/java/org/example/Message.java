package org.example;

import java.util.Arrays;

public class Message {

    private String body;
    private String from;
    private int toUserId;
    private String[] destinations;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public String[] getDestinations() {
        return destinations;
    }

    public void setDestinations(String[] destinations) {
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        return "Message{" +
               "body='" + body + '\'' +
               ", from='" + from + '\'' +
               ", toUserId=" + toUserId +
               ", destinations=" + Arrays.toString(destinations) +
               '}';
    }
}
