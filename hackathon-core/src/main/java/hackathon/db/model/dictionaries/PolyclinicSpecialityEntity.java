package hackathon.db.model.dictionaries;

import javax.persistence.*;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@Entity
@Table(name = "polyclinic_speciality")
public class PolyclinicSpecialityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "polyclinic")
    private Long polyclinic;

    @Column(name = "speciality")
    private Long speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(Long polyclinic) {
        this.polyclinic = polyclinic;
    }

    public Long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Long speciality) {
        this.speciality = speciality;
    }

}
