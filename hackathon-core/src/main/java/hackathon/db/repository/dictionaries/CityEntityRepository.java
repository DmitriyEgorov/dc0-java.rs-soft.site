package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public interface CityEntityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findCityEntitiesByRegionId(Long regionId);
}
