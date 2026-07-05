package com.example.dead_letter_queue;

public class Message {

    private String id;
    private String content;
    private int retryCount;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
        this.retryCount = 0;
    }

    public String getId() { return id; }
    public String getContent() { return content; }
    public int getRetryCount() { return retryCount; }
    public void incrementRetry() { retryCount++; }

    @Override
    public String toString() {
        return "Message{id='" + id + "', content='" + content + 
               "', retryCount=" + retryCount + "}";
    }
}