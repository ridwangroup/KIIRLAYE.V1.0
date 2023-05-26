package sn.ridwan.security.sessions;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(name = "sessions")
@Inheritance(strategy = InheritanceType.JOINED)
public class SessionEntity {

    @Id
    @Column(name = "id_sessions")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime sessionStart = LocalDateTime.now();

    @Column
    private LocalDateTime  sessionEnd;

    @Column
    // Lifetime duration in milliseconds
    private long sessionLifetime=60000;

    @Column(nullable = false)
    private String loginType;

    @Column(nullable = false)
    private String loginValue;

    @Column(nullable = false)
    private String userId;

    @Column
    private boolean actif=true;

    public SessionEntity(String loginType, String loginValue, String userId) {
        this.loginType = loginType;
        this.loginValue = loginValue;
        this.userId = userId;
    }

    public SessionEntity(){}

    public UUID getId() {
        return id;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getLoginValue() {
        return loginValue;
    }

    public void setLoginValue(String loginValue) {
        this.loginValue = loginValue;
    }



    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public LocalDateTime getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(LocalDateTime sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public long getSessionLifetime() {
        return sessionLifetime;
    }

    public void setSessionLifetime(long sessionLifetime) {
        this.sessionLifetime = sessionLifetime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @PrePersist
    public void prePersist() {
        if (sessionStart == null) {
            sessionStart = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (sessionEnd != null) {
            throw new IllegalStateException("Cannot update sessionEnd once it has been set.");
        }
    }

    public void endSession() {
        if (sessionEnd == null) {
            sessionEnd = LocalDateTime.now();
        }
    }

    public void updateSessionLifetime(long sessionLifetime) {
        this.sessionLifetime = sessionLifetime;
    }

    public boolean isExpired() {
      if (getSessionStart() == null) {
            System.out.println("##############\nsessionStart==null : "+sessionStart+"\n##############");
            return true; // Session has not started yet
        }

        if (getSessionLifetime() <= 0) {
            System.out.println("##############\nsessionLifetime < 0 : "+sessionLifetime+"\n##############");
            return false; // Session has no lifetime defined
        }

        LocalDateTime now = LocalDateTime.now();
        sessionEnd = getSessionStart().plus(getSessionLifetime(), ChronoUnit.MILLIS);
        System.out.println("##############\nexpirationTime : "+sessionEnd+"\n##############");

        return now.isAfter(sessionEnd);
    }

}
