package com.example.dead_letter_queue;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class MessageProcessor {

    private static final int MAX_RETRIES = 3;

    // Main queue
    private final ConcurrentLinkedQueue<Message> mainQueue 
        = new ConcurrentLinkedQueue<>();

    // Dead Letter Queue
    private final ConcurrentLinkedQueue<Message> deadLetterQueue 
        = new ConcurrentLinkedQueue<>();

    public void sendMessage(String id, String content) {
        mainQueue.add(new Message(id, content));
    }

    public String processNextMessage() {
        Message message = mainQueue.poll();

        if (message == null) {
            return "No messages in queue";
        }

        try {
            // Simulate 70% failure rate
            if (Math.random() > 0.3) {
                throw new RuntimeException("Processing failed!");
            }

            return "✅ Message processed: " + message.getId();

        } catch (Exception e) {
            message.incrementRetry();

            if (message.getRetryCount() >= MAX_RETRIES) {
                deadLetterQueue.add(message);
                return "❌ Message moved to DLQ after " + 
                       MAX_RETRIES + " retries: " + message.getId();
            } else {
                mainQueue.add(message);
                return "⚠️ Message failed, retry " + 
                       message.getRetryCount() + "/" + MAX_RETRIES + 
                       ": " + message.getId();
            }
        }
    }

    public List<String> getDeadLetterQueue() {
        List<String> dlq = new ArrayList<>();
        deadLetterQueue.forEach(m -> dlq.add(m.toString()));
        return dlq;
    }

    public int getMainQueueSize() { return mainQueue.size(); }
    public int getDLQSize() { return deadLetterQueue.size(); }
}