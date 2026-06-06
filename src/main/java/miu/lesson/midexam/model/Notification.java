package miu.lesson.midexam.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private String id;
    private LocalDateTime sentAt;
    private String channel;

    public Notification(String channel) {
        this.id = UUID.randomUUID().toString();
        this.sentAt = LocalDateTime.now();
        this.channel = channel;
    }

    public String getId()            { return id; }
    public LocalDateTime getSentAt() { return sentAt; }
    public String getChannel()       { return channel; }

    public void send() { }
}
