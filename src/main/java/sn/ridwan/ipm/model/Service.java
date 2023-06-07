package sn.ridwan.ipm.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SERVICES")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nomService;
    @Column
    private boolean etatService;
    @ManyToMany
    private List<StructureSanitaire> structureSanitaireList;
}
