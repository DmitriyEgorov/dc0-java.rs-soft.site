package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.PolyclinicSpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public interface PolyclinicSpecialityEntityRepository extends JpaRepository<PolyclinicSpecialityEntity, Long> {
}
