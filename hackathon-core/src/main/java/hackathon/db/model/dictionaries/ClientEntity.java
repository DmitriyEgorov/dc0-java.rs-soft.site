package hackathon.db.model.dictionaries;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * client's data stored in DB
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /* role of client */
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private ClientRole clientRole;

    /* login of client */
    @Column(name = "username")
    private String login;

    /* password of client */
    @Column(name = "password")
    private String password;

    /* oms */
    @Column(name = "oms")
    private String oms;

    /* full name of client */
    @Column(name = "fullname")
    private String fullNaMe;

    /* state of account */
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ClientRole status;

    /* default polyclinic of client */
    @Column(name = "polyclinic")
    private Long polyclinicId;

    /* date and time of creation of account*/
    @Column(name = "created_at")
    private LocalDateTime created_at;

    /* date and time od deleting of account */
    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    /* verification_token of session */
    @Column(name = "verification_token")
    private String verification_token;

    /* auth_key */
    @Column(name = "auth_key")
    private String auth_key;

    /* password_reset_token of session */
    @Column(name = "password_reset_token")
    private String password_reset_token;

    /* email of client */
    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientRole getClientRole() {
        return clientRole;
    }

    public void setClientRole(ClientRole clientRole) {
        this.clientRole = clientRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOms() {
        return oms;
    }

    public void setOms(String oms) {
        this.oms = oms;
    }

    public String getFullNaMe() {
        return fullNaMe;
    }

    public void setFullNaMe(String fullNaMe) {
        this.fullNaMe = fullNaMe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ClientRole getStatus() {
        return status;
    }

    public void setStatus(ClientRole status) {
        this.status = status;
    }

    public Long getPolyclinicId() {
        return polyclinicId;
    }

    public void setPolyclinicId(Long polyclinicId) {
        this.polyclinicId = polyclinicId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getVerification_token() {
        return verification_token;
    }

    public void setVerification_token(String verification_token) {
        this.verification_token = verification_token;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getPassword_reset_token() {
        return password_reset_token;
    }

    public void setPassword_reset_token(String password_reset_token) {
        this.password_reset_token = password_reset_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
