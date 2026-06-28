package com.example.idempotency;

import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IdempotencyStore {

    private final ConcurrentHashMap<String, String> store = new ConcurrentHashMap<>();

    public boolean contains(String key) {
        return store.containsKey(key);
    }

    public void save(String key, String response) {
        store.put(key, response);
    }

    public String get(String key) {
        return store.get(key);
    }
}