package hackathon.db.model.dictionaries;

import javax.persistence.*;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Entity
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "city_name")
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
