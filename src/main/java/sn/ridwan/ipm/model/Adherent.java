package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="ADHERENTS")
public class Adherent extends User{
    @Column
    private String adresse;
    @Column
    private Date dateNaiss;
    @Column
    private String lieuNaiss;
}
