package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "ENTREPRISE_CLIENTS")
public class EntrepriseClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ est obligatoire !")
    @Column
    private String nomEntre;
    @NotEmpty(message = "Ce champ est obligatoire !")
    @Column
    private String ninea;
    @NotEmpty(message = "Ce champ est obligatoire !")
    @Column
    private String numRc;
    @NotEmpty(message = "Ce champ est obligatoire !")
    @Column
    private String adresse;
    @NotEmpty(message = "Ce champ est obligatoire !")
    @Column
    private String numTele;
    @Column
    private boolean isEtat =true;
}
