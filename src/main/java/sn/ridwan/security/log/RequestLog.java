package sn.ridwan.security.log;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class RequestLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    /*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="createAtBy",referencedColumnName = "id",updatable=false,nullable = false)
    private User createAtBy;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

   public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    /*
    public User getCreateAtBy() {
        return createAtBy;
    }

    public void setCreateAtBy(User createAtBy) {
        this.createAtBy = createAtBy;
    }*/
// Constructors, getters, and setters
}