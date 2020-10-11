package com.ithillel.service.textprocessor;

import com.ithillel.service.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class InMemoryTextProcessor implements TextProcessor {

    private final Storage storage;

    @Autowired
    public InMemoryTextProcessor(Storage storage) {
        this.storage = storage;
    }

    public void save(String key, final String text) {
        if (isEmpty(key)) throw new IllegalArgumentException("key must be a set");
        if (isEmpty(text)) return;
        storage.compute(key, (k, value) -> (value == null ? text : "\n" + text));
    }

    private boolean isEmpty(String key) {
        return Objects.isNull(key) || key.isEmpty();
    }

    public String getByKey(String key) {
        if (isEmpty(key)) throw new IllegalArgumentException("key must be a set");
        String text = storage.get(key);
        if (text == null) throw new IllegalStateException("key not found");
        return text;
    }

    public Storage getStorage() {
        return storage;
    }
}
