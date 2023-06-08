package sn.ridwan.ipm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SERVICES")
@NamedQuery(name = "Service.findAll", query = "SELECT service FROM Service service WHERE service.etatService=true")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nomService;
    @Column
    private boolean etatService=true;

    @Column(updatable=false,nullable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name="updateBy")
    private Long updateBy;
    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Services_StructuresSanitaires> servicesStructuresSanitairesList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
    @JoinColumn(name="createBy",referencedColumnName = "id",updatable=false,nullable = false)
    private Agent createBy;

    @OneToMany(mappedBy = "createBy", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @Column(insertable=false, updatable=false,nullable = true)
    @JsonIgnore
    private List<Service> serviceList;

    public Service(String nomService, boolean etatService, Date createdAt, Date updatedAt, Long updateBy, List<Services_StructuresSanitaires> servicesStructuresSanitairesList, Agent createBy, List<Service> serviceList) {
        this.nomService = nomService;
        this.etatService = etatService;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.updateBy = updateBy;
        this.servicesStructuresSanitairesList = servicesStructuresSanitairesList;
        this.createBy = createBy;
        this.serviceList = serviceList;
    }
}