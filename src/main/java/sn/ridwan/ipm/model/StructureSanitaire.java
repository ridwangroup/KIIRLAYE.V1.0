package sn.ridwan.ipm.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "STRUCTURES_SANITAIRES")
public class StructureSanitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String numRC;
    @Column
    private String raisonSociale;
    @Column
    private String ninea;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private String plateauMedical;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "structureSanitaire_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> serviceList;
}
