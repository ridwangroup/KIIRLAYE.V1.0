package sn.ridwan.ipm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Column
    private Date dateNaiss;
    @Column
    private String lieuNaiss;
    @Column
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
