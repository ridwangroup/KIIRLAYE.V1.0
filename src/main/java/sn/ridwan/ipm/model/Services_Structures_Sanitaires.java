package sn.ridwan.ipm.model;

import jakarta.persistence.*;

@Entity
public class Services_Structures_Sanitaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long service_id;
    @Column
    private long structuresanitairelist_id;
}
