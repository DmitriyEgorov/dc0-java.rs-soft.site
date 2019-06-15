package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.RegionEntity;
import hackathon.db.repository.dictionaries.RegionEntityRepository;
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
    private MockMvc mvc;

    @Test
    public void test_emptyList() throws Exception {
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
    public void test_notEmptyList() throws Exception {
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

}