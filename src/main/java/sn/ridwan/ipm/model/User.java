package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import sn.ridwan.ipm.services.implement.userImplement;
import sn.ridwan.security.log.Log;

import java.io.Serializable;
import java.util.*;

import static sn.ridwan.security.helpers.ValidatorHelper.HashPlainPassword;


@NoArgsConstructor
@ToString
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "User.findAll", query = "SELECT us FROM User us")
@Log
public class User extends userImplement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String genre;
    @Column
    private boolean isEtat = true;
    @Column(name = "password")
    private String password = HashPlainPassword("passer");
    @Transient
    private String login="";
    @Transient
    private String token="";
    @Column(name = "userIdd",unique=true)
    private String userIdd;
    @Column(name = "telephone",unique=true)
    private String tel;
    @Column(name = "email",unique=true)
    private String email;

    @Column
    private boolean firstConnection=false;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private ArrayList<Role> roles;

    @Column
    private String image = "https://www.w3schools.com/howto/img_avatar.png";

    @Column
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;




    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RolesPermissions> rolesList;

    public List<RolesPermissions> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<RolesPermissions> rolesList) {
        this.rolesList = rolesList;
    }




  /*  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.DETACH,orphanRemoval = true)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private Set<User_Roles> user_RolesList = new HashSet<>();*/


    public User(Long id) {
        this.id=id;
    }

    public User(String nom, String prenom, String genre, String userIdd, String tel,String email, ArrayList<Role> roles, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.tel = tel;
        this.email= email;
        this.roles = roles;
        this.image = image;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public boolean isEtat() {
        return isEtat;
    }
    public void setIsEtat(boolean etat) {
        isEtat = etat;
    }
    public String getUserIdd() {
        return userIdd;
    }
    public void setUserIdd(String userIdd) {
        this.userIdd = userIdd;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}
    public ArrayList<Role> getRoles() {return roles;}
    public void setRoles(ArrayList<Role> roles) {this.roles = roles;}
    public boolean isFirstConnection() {return firstConnection;}
    public void setFirstConnection(boolean firstConnection) {this.firstConnection = firstConnection;}

    public void addRole(RolesPermissions role) {
        this.rolesList.add(role);
    }
   /* public void addUserRole(User_Roles userRole) {
        user_RolesList.add(userRole);
        userRole.setUser(this);
    }

    public void removeUserRole(User_Roles userRole) {
        user_RolesList.remove(userRole);
        userRole.setUser(null);
    }*/
}
