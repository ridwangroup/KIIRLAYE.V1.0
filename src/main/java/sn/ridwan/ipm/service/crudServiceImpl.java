package sn.ridwan.ipm.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.service.spi.InjectService;
import sn.ridwan.ipm.interfaces.crudInterface;
import sn.ridwan.ipm.model.Agent;

import java.util.List;


public  class crudServiceImpl {
    @PersistenceContext(unitName="Ridwan")
    private EntityManager em;



}
