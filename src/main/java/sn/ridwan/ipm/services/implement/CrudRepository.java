package sn.ridwan.ipm.services.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sn.ridwan.ipm.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudRepository<T> {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;

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

    public void findByEmail(String email){
        TypedQuery<User> emailLogin =em.createQuery("SELECT user From User user WHERE user.email=:login AND user.isEtat=true", User.class);
    }
}
