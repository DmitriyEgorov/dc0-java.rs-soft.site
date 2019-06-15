package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.CityEntity;
import hackathon.db.model.dictionaries.RegionEntity;
import hackathon.db.repository.dictionaries.CityEntityRepository;
import hackathon.db.repository.dictionaries.RegionEntityRepository;
import hackathon.model.dictionaries.City;
import hackathon.model.dictionaries.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static hackathon.adapter.dictionaries.CityAdapter.adaptCities;
import static hackathon.adapter.dictionaries.RegionAdapter.adaptRegions;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonApplication.class)
@AutoConfigureMockMvc
public class RegionControllerTest {

    private static final String REGION_PATH = "/dictionaries/regions";

    @Autowired
    private RegionEntityRepository regionEntityRepository;

    @Autowired
    private CityEntityRepository cityEntityRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_emptyRegionList() throws Exception {
        regionEntityRepository.deleteAll();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(REGION_PATH)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Region> regions = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Region>>() {});

        assertTrue(regions.isEmpty());
    }

    @Test
    public void test_notEmptyRegionList() throws Exception {
        RegionEntity regionEntity_1 = new RegionEntity();
        String regionName_1 = "regionName_1";
        regionEntity_1.setRegionName(regionName_1);
        regionEntityRepository.save(regionEntity_1);

        RegionEntity regionEntity_2 = new RegionEntity();
        String regionName_2 = "regionName_2";
        regionEntity_2.setRegionName(regionName_2);
        regionEntityRepository.save(regionEntity_2);

        List<Region> regionsExpected = adaptRegions(regionEntityRepository.findAll());

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(REGION_PATH)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Region> regionsReal = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Region>>() {});

        assertEquals(regionsExpected.size(), regionsReal.size());
        assertTrue(regionsReal.containsAll(regionsExpected));
    }

    @Test
    public void test_notEmptyCityList() throws Exception {
        Long regionId = 1L;
        CityEntity cityEntity_1 = new CityEntity();
        cityEntity_1.setRegionId(regionId);
        String cityName_1 = "cityName_1";
        cityEntity_1.setCityName(cityName_1);
        cityEntityRepository.save(cityEntity_1);

        CityEntity cityEntity_2 = new CityEntity();
        String cityName_2 = "cityName_2";
        cityEntity_2.setRegionId(regionId);
        cityEntity_2.setCityName(cityName_2);
        cityEntityRepository.save(cityEntity_2);

        List<City> citiesExpected = adaptCities(cityEntityRepository.findAll());

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                REGION_PATH.concat("/{regionId}/cities"), regionId)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<City> citiesReal = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<City>>() {});

        assertEquals(citiesExpected.size(), citiesReal.size());
        assertTrue(citiesReal.containsAll(citiesExpected));
    }

    @Test
    public void test_emptyCitiesList() throws Exception {
        regionEntityRepository.deleteAll();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                REGION_PATH.concat("/{regionId}/cities"), Long.MAX_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<City> regions = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<City>>() {});

        assertTrue(regions.isEmpty());
    }

}