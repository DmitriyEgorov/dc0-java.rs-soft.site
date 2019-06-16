package hackathon.adapter.dictionaries;

import hackathon.db.model.dictionaries.CityEntity;
import hackathon.model.dictionaries.City;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public class CityAdapter {

    public static List<City> adaptCities(List<CityEntity> cityEntities) {
        return cityEntities == null ?
                new ArrayList<>() :
                cityEntities.stream().map(CityAdapter::adaptCity).collect(Collectors.toList());

    }

    private static City adaptCity(CityEntity cityEntity) {
        City city = new City();
        city.setId(cityEntity.getId());
        city.setName(cityEntity.getCityName());
        return city;
    }
}
