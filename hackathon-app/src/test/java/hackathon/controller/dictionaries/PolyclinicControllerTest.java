package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.PolyclinicSpecialityEntity;
import hackathon.db.model.dictionaries.SpecialityEntity;
import hackathon.db.repository.dictionaries.PolyclinicSpecialityEntityRepository;
import hackathon.db.repository.dictionaries.SpecialityEntityRepository;
import hackathon.model.dictionaries.Speciality;
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

import static hackathon.adapter.dictionaries.SpecialityAdapter.adaptSpecialities;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonApplication.class)
@AutoConfigureMockMvc
public class PolyclinicControllerTest {

    private static final String POLYCLINIC_PATH = "/dictionaries/polyclinic";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PolyclinicSpecialityEntityRepository polyclinicSpecialityEntityRepository;

    @Autowired
    private SpecialityEntityRepository specialityEntityRepository;


    @Test
    public void test_notEmptySpecialitiesList() throws Exception {
        Long id = 1L;
        SpecialityEntity specialityEntity_1 = new SpecialityEntity();
        String specialityName_1 = "specialityName_1";
        specialityEntity_1.setName(specialityName_1);
        specialityEntity_1 = specialityEntityRepository.save(specialityEntity_1);

        SpecialityEntity specialityEntity_2 = new SpecialityEntity();
        String specialityName_2 = "specialityName_1";
        specialityEntity_2.setName(specialityName_2);
        specialityEntityRepository.save(specialityEntity_2);

        PolyclinicSpecialityEntity polyclinicSpecialityEntity_1 = new PolyclinicSpecialityEntity();
        polyclinicSpecialityEntity_1.setPolyclinic(id);
        polyclinicSpecialityEntity_1.setSpeciality(specialityEntity_1.getId());
        polyclinicSpecialityEntityRepository.save(polyclinicSpecialityEntity_1);

        PolyclinicSpecialityEntity polyclinicSpecialityEntity_2 = new PolyclinicSpecialityEntity();
        polyclinicSpecialityEntity_2.setPolyclinic(id);
        polyclinicSpecialityEntity_2.setSpeciality(specialityEntity_2.getId());
        polyclinicSpecialityEntityRepository.save(polyclinicSpecialityEntity_2);

        List<Speciality> regionsExpected = adaptSpecialities(specialityEntityRepository.findAll());

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                POLYCLINIC_PATH.concat("/{polyclinicId}/specialities"), id)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Speciality> regionsReal = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Speciality>>() {});

        assertEquals(regionsExpected.size(), regionsReal.size());
        assertTrue(regionsReal.containsAll(regionsExpected));
    }

    @Test
    public void test_emptySpecialitiesList() throws Exception {
        polyclinicSpecialityEntityRepository.deleteAll();
        specialityEntityRepository.deleteAll();

        List<Speciality> citiesExpected = adaptSpecialities(specialityEntityRepository.findAll());

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(
                POLYCLINIC_PATH.concat("/{polyclinicId}/specialities"), Long.MAX_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        List<Speciality> citiesReal = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<List<Speciality>>() {});

        assertEquals(citiesExpected.size(), citiesReal.size());
        assertTrue(citiesReal.containsAll(citiesExpected));
    }



}