package hackathon.db.model.dictionaries;

import javax.persistence.*;

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

    @Column(name = "client_role")
    @Enumerated(value = EnumType.STRING)
    private ClientRole clientRole;

    @Column(name = "password")
    private String password;

    @Column(name = "oms")
    private String oms;

    @Column(name = "full_name")
    private String fullNaMe;


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
}
