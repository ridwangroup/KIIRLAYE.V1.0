package sn.ridwan.ipm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class User extends Personne {
    @Column(unique=true)
    protected String email;

    @Column(unique=true)
    protected String numTelephone;

    @Column(unique=true)
    protected String ipmId;

    protected String password;


}
