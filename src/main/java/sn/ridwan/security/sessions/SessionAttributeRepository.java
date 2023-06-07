package sn.ridwan.security.sessions;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SessionAttributeRepository {

    @PersistenceContext(unitName ="Ridwan")
    private EntityManager em;

    @Transactional
    public void storeSessionAttribute(String loginType,String loginValue, String userId) {
    //Stockage de l'attribut de session dans la base de donnee
        SessionEntity attributeEntity = new SessionEntity();
      /*  if(attributeEntity.isExpired()){
            System.out.println("#######################\nattributeEntity.isExpired() : "+attributeEntity.isExpired()+"\n#######################");
        }*/

        attributeEntity.setLoginType(loginType);
        attributeEntity.setLoginValue(loginValue);
        attributeEntity.setUserId(userId);
        em.persist(attributeEntity);
   // }
    }
}
