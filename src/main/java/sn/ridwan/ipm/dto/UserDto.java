package sn.ridwan.ipm.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import sn.ridwan.ipm.model.User;

import java.util.Date;

/*@Data
@Builder
@ToString*/
public class UserDto {
/*
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private String userIdd;
    private Date createdAt;
    private Date updatedAt;

    public UserDto fromEntity(User user){
        if(user==null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .prenom(user.getPrenom())
                .nom(user.getNom())
                .genre(user.getGenre())
                .userIdd(user.getUserIdd())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }*/

}
