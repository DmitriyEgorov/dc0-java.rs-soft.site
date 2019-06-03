package hackathon.controller;

import hackathon.config.HackathonApplication;
import hackathon.db.model.TestDataEntity;
import hackathon.db.repository.TestDataEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test for TestController
 *
 * @author Dmitriy
 * @since 31.05.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HackathonApplication.class)
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {

    @Autowired
    private TestDataEntityRepository testDataEntityRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHi() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Dmitriy, Mickhail and Sergey say hi!")));
    }

    @Test
    public void testPing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/ping")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(mvcResult ->
                        assertTrue(mvcResult.getResponse().getContentAsString().contains("test success")));

    }

    @Test
    public void testData_success() throws Exception {
        String test_data = "test_data";
        TestDataEntity testDataEntity = new TestDataEntity();
        testDataEntity.setData(test_data);
        testDataEntity = testDataEntityRepository.save(testDataEntity);
        mvc.perform(MockMvcRequestBuilders.get("/data/{id}", testDataEntity.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(mvcResult ->
                        assertTrue(mvcResult.getResponse().getContentAsString().contains(test_data)));
    }

    @Test
    public void testData_notFound() throws Exception {
        testDataEntityRepository.deleteAll();
        mvc.perform(MockMvcRequestBuilders.get("/data/{id}", Long.MAX_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testData_badRequest() throws Exception {
        testDataEntityRepository.deleteAll();
        mvc.perform(MockMvcRequestBuilders.get("/data/{id}", "string")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
