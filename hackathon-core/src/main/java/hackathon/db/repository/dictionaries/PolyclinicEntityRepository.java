package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.PolyclinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public interface PolyclinicEntityRepository extends JpaRepository<PolyclinicEntity, Long> {

    List<PolyclinicEntity> findByCityId(Long cityId);

}
