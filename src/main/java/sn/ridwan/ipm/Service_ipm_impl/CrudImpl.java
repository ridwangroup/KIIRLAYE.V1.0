package sn.ridwan.ipm.Service_ipm_impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.ridwan.ipm.model.User;
import sn.ridwan.ipm.service_ipm_interfaces.CrudInterfaces;

import java.util.List;

@ApplicationScoped
public class CrudImpl implements CrudInterfaces {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;
    @Override
    public List getAll(String classNameMethod) {
        Query namedQuery = em.createNamedQuery(classNameMethod);
        namedQuery.getResultList();
        List userList = namedQuery.getResultList();
        return userList;
    }
    @Override
    public Object getById(Long id) {
        Object ob = em.find(User.class,id);
        //System.out.println("em.find(Adherent.class,id) : "+ob);
        return ob;
    }
    @Override
    public Object create(Object ob) {
        em.persist(ob);
        System.out.println("em.persist(user) : "+ob);
        return ob;
    }

  /*  @Override
    public Object update(@PathParam("id") Long id,Object ob) {
        ob = em.find(Object.class, id);
        em.merge(ob);
        System.out.println("em.merge(ob) : "+ob);
        return Response.ok(ob).build();
    }

    @Override
    public Object delete(@PathParam("id") Long id) {
       Object  ob = em.find(Object.class, id);
         em.remove(ob);
        return  Response.ok(ob).build();
    }*/
}
