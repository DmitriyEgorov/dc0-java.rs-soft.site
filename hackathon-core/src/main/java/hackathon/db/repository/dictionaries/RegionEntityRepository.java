package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository for regions
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
public interface RegionEntityRepository extends JpaRepository<RegionEntity, Long> {

}
