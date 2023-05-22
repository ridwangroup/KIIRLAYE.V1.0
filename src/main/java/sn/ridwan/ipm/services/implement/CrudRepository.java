package sn.ridwan.ipm.services.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudRepository<T> {

    private Map<String, T> repository;

    public CrudRepository() {
        repository = new HashMap<>();
    }

    public T create(String id, T object) {
        repository.put(id, object);
        return object;
    }

    public T read(String id) {
        return repository.get(id);
    }

    public T update(String id, T object) {
        repository.put(id, object);
        return object;
    }

    public void delete(String id) {
        repository.remove(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(repository.values());
    }
}
