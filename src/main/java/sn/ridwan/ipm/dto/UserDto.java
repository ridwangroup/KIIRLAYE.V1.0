package sn.ridwan.ipm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import sn.ridwan.ipm.model.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.User} entity
 */

@Data
public class UserDto implements Serializable {

    private final Long idDto;
    private final String nomDto;
    private final String prenomDto;
    private final String emailDto;
  /*  private final String genre;
    private final String userIdd;
    private final String tel;

    private final ArrayList<Role> roles;
    private final String image;
    private final Date createdAt;
    private final Date updatedAt;*/



   /* public UserDto(Long id, String nom, String prenom, String genre, String userIdd, String tel, String email, ArrayList<Role> roles, String image, Date createdAt, Date updatedAt) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.userIdd = userIdd;
        this.tel = tel;
        this.email = email;
        this.roles = roles;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
    }*/

  /*  public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }*/

/*    public String getGenre() {
        return genre;
    }

    public String getUserIdd() {
        return userIdd;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public String getImage() {
        return image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {
        return id;
    }*/
}