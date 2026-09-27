package com.soltrix.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class InMemoryRepository<T, ID> {

    protected final Map<ID, T> storage = new ConcurrentHashMap<>();
    protected final AtomicLong idGenerator = new AtomicLong(1);

    protected abstract ID getId(T entity);
    protected abstract void setId(T entity, ID id);

    @SuppressWarnings("unchecked")
    public synchronized T save(T entity) {
        if (entity == null) return null;
        ID id = getId(entity);
        if (id == null) {
            id = (ID) Long.valueOf(idGenerator.getAndIncrement());
            setId(entity, id);
        } else if (id instanceof Long && ((Long) id) >= idGenerator.get()) {
            idGenerator.set(((Long) id) + 1);
        }
        storage.put(id, entity);
        return entity;
    }

    public synchronized List<T> saveAll(Iterable<T> entities) {
        List<T> result = new ArrayList<>();
        if (entities != null) {
            for (T entity : entities) {
                result.add(save(entity));
            }
        }
        return result;
    }

    public Optional<T> findById(ID id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(storage.get(id));
    }

    public boolean existsById(ID id) {
        return id != null && storage.containsKey(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public long count() {
        return storage.size();
    }

    public synchronized void deleteById(ID id) {
        if (id != null) {
            storage.remove(id);
        }
    }

    public synchronized void delete(T entity) {
        if (entity != null) {
            ID id = getId(entity);
            if (id != null) {
                storage.remove(id);
            }
        }
    }

    public synchronized void deleteAll() {
        storage.clear();
    }
}
