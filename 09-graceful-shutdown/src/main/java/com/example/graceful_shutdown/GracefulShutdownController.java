package com.example.graceful_shutdown;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class GracefulShutdownController {

    @GetMapping("/long-task")
    public ResponseEntity<String> longRunningTask() throws InterruptedException {
        System.out.println("Task started... processing for 10 seconds");

        // Simulate a long-running task (e.g. writing to DB, calling external API)
        Thread.sleep(10000);

        System.out.println("Task completed successfully!");
        return ResponseEntity.ok("Long task completed without interruption!");
    }
}