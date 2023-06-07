package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class RolesPermissions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String roleName;



 /*   @OneToMany(mappedBy = "roles_permissions", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<User_Roles> user_RolesList = new ArrayList<>();*/

    public RolesPermissions(){

    }
    public RolesPermissions(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
  /*  public List<User_Roles> getUser_RolesList() {
        return user_RolesList;
    }

    public void setUser_RolesList(List<User_Roles> user_RolesList) {
        this.user_RolesList = user_RolesList;
    }*/
}
