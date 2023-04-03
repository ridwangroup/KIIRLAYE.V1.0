package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adherent  extends  User{
    private String adresse;

    private Date dateNaiss;

    private String lieuNaiss;

}
