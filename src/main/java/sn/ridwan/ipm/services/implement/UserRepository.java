package sn.ridwan.ipm.services.implement;

import jakarta.ejb.Stateless;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.ridwan.ipm.model.User;

@Stateless(name = "JpaRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByTelephone(String telephone);
    User findByUserId(String userId);
}
