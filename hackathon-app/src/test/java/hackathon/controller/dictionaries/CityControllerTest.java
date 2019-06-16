package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.PolyclinicEntity;
import hackathon.db.repository.dictionaries.PolyclinicEntityRepository;
import hackathon.model.dictionaries.Polyclinic;
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

import static hackathon.adapter.dictionaries.PolyclinicAdapter.adaptPolyclinics;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonApplication.class)
@AutoConfigureMockMvc
public class CityControllerTest {

    private static final String CITY_PATH = "/dictionaries/cities";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PolyclinicEntityRepository polyclinicEntityRepository;

    @Test
    public void test_notEmptyCityList() throws Exception {
        Long cityId = 1L;
        PolyclinicEntity polyclinicEntity_1 = new PolyclinicEntity();
        polyclinicEntity_1.setCityId(cityId);
        String polyclinicName_1 = "polyclinicName_1";
        polyclinicEntity_1.setName(polyclinicName_1);
        polyclinicEntityRepository.save(polyclinicEntity_1);

        PolyclinicEntity polyclinicEntity_2 = new PolyclinicEntity();
        String polyclinicName_2 = "polyclinicName_2";
        polyclinicEntity_2.setCityId(cityId);
        polyclinicEntity_2.setName(polyclinicName_2);
        polyclinicEntityRepository.save(polyclinicEntity_2);

        List<Polyclinic> citiesExpected = adaptPolyclinics(polyclinicEntityRepository.findAll());

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                CITY_PATH.concat("/{cityId}/polyclinics"), cityId)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Polyclinic> citiesReal = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Polyclinic>>() {});

        assertEquals(citiesExpected.size(), citiesReal.size());
        assertTrue(citiesReal.containsAll(citiesExpected));
    }

    @Test
    public void test_emptyCitiesList() throws Exception {
        polyclinicEntityRepository.deleteAll();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                CITY_PATH.concat("/{cityId}/polyclinics"), Long.MAX_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Polyclinic> regions = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Polyclinic>>() {});

        assertTrue(regions.isEmpty());
    }
}