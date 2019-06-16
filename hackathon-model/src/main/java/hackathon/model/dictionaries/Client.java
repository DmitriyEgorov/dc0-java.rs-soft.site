package hackathon.model.dictionaries;

/**
 * client's dats
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
public class Client {

    private Long id;

    private String OMS;

    private String fullNaMe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOMS() {
        return OMS;
    }

    public void setOMS(String OMS) {
        this.OMS = OMS;
    }

    public String getFullNaMe() {
        return fullNaMe;
    }

    public void setFullNaMe(String fullNaMe) {
        this.fullNaMe = fullNaMe;
    }
}
