package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.CityEntity;
import hackathon.db.repository.dictionaries.CityEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class CityEntityService {

    private final CityEntityRepository cityEntityRepository;

    public CityEntityService(CityEntityRepository cityEntityRepository) {
        this.cityEntityRepository = cityEntityRepository;
    }

    public List<CityEntity> findCitiesByRegionId(Long regionId) {
        return cityEntityRepository.findCityEntitiesByRegionId(regionId);
    }
}
