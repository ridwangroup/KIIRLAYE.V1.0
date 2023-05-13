package sn.ridwan.ipm.dto;

import lombok.Data;
import sn.ridwan.ipm.model.Role;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link sn.ridwan.ipm.model.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String prenom;
    private final String genre;
    private final String userIdd;
    private final String tel;
    private final String email;
    private final Role roles;
    private final String image;

}