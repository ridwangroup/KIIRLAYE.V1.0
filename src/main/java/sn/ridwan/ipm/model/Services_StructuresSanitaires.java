package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SERVICES_SS")
@NamedQuery(name = "Services_StructuresSanitaires.findAll", query = "SELECT sss FROM Services_StructuresSanitaires sss WHERE sss.etatSERVICES_SS=true")
public class Services_StructuresSanitaires implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean etatSERVICES_SS=true;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="service_id",referencedColumnName = "id",nullable = true,insertable=false, updatable=false)
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="structureSanitaire_id",referencedColumnName = "id",nullable = true,insertable=false, updatable=false)
    private StructureSanitaire structureSanitaire;


    public Services_StructuresSanitaires( boolean etatSERVICES_SS, Service service, StructureSanitaire structureSanitaire) {
        this.etatSERVICES_SS = etatSERVICES_SS;
        this.service = service;
        this.structureSanitaire = structureSanitaire;
    }
}
