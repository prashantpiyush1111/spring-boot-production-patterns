package com.example.dead_letter_queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/queue")
public class DLQController {

    @Autowired
    private MessageProcessor messageProcessor;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(
            @RequestParam String id,
            @RequestParam String content) {
        messageProcessor.sendMessage(id, content);
        return ResponseEntity.ok("Message added to queue: " + id);
    }

    @GetMapping("/process")
    public ResponseEntity<String> processMessage() {
        String result = messageProcessor.processNextMessage();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/dlq")
    public ResponseEntity<List<String>> getDeadLetterQueue() {
        return ResponseEntity.ok(messageProcessor.getDeadLetterQueue());
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(
            "Main Queue: " + messageProcessor.getMainQueueSize() + 
            " messages | DLQ: " + messageProcessor.getDLQSize() + " messages"
        );
    }
}