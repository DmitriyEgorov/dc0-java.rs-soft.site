package hackathon.processor.dictionaries;

import hackathon.model.dictionaries.City;
import hackathon.service.dictionaries.CityEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

import static hackathon.adapter.dictionaries.CityAdapter.adaptCities;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class CityProcessor {

    private final CityEntityService cityEntityService;

    public CityProcessor(CityEntityService cityEntityService) {
        this.cityEntityService = cityEntityService;
    }

    public List<City> findCitiesByRegionId(Long regionId) {
        return adaptCities(cityEntityService.findCitiesByRegionId(regionId));
    }
}
