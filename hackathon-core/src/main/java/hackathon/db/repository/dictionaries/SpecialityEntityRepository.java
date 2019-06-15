package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.SpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public interface SpecialityEntityRepository extends JpaRepository<SpecialityEntity, Long> {

    @Query(
            value = "SELECT * from speciality join polyclinic_speciality " +
                    " on speciality.id = polyclinic_speciality.speciality " +
                    " where polyclinic_speciality.polyclinic = :id",
            nativeQuery = true)
    List<SpecialityEntity> findByPolyclinicId(@Param("id") Long id);

}
