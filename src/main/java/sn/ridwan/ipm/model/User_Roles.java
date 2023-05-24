package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.io.Serializable;

//@Entity

//@NamedQuery(name = "UserRoles.findAll", query = "SELECT us FROM User_Roles us")
public class User_Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="roles_id",referencedColumnName = "id",nullable = true)
    private RolesPermissions roles_permissions;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="user_id",referencedColumnName = "id",nullable = true)
    private User user;*/

   /* public User_Roles(Long id, RolesPermissions roles_permissions, User user) {
        this.id = id;
        this.roles_permissions = roles_permissions;
        this.user = user;
    }*/

    public User_Roles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public RolesPermissions getRoles_permissions() {
        return roles_permissions;
    }

    public void setRoles_permissions(RolesPermissions roles_permissions) {
        this.roles_permissions = roles_permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

}
