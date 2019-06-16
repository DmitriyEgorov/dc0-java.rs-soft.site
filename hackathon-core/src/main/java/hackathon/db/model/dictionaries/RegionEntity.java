package hackathon.db.model.dictionaries;

import javax.persistence.*;

/**
 * region's data
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Entity
@Table(name = "regions")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String regionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
