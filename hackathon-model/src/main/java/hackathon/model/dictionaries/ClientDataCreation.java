package hackathon.model.dictionaries;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public class ClientDataCreation {

    private String login;

    private String password;

    private String oms;

    private String fullName;

    private Long polyclinicId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPolyclinicId() {
        return polyclinicId;
    }

    public void setPolyclinicId(Long polyclinicId) {
        this.polyclinicId = polyclinicId;
    }
}
