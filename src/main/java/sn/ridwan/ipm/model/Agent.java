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
@Table(name="AGENTS")
public class Agent extends User{
    @Column
    private String adresse;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateNaiss;
    @Column
    private String lieuNaiss;
    @Column(name = "matricule", unique=true)
    private String matricule;
    @Column
    private String conventionCollective;
    @Column
    private String poste;
    @Column
    private String hierarchie;
    @Column
    private String image;
}
