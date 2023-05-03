package sn.ridwan.ipm.service_ipm_interfaces;

import jakarta.ejb.Local;
import jakarta.ws.rs.core.Response;
import sn.ridwan.ipm.model.Adherent;

import java.util.List;

@Local
public interface CrudInterfaces {

    public List getAll(String classNameMethod) ;

    public Object getById(Long id);

    public Object create(Object ob);

 /*   public Object update(Long id, Object ob);

    public Object delete(Long id);*/

}
