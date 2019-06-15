package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.ClientEntity;
import hackathon.db.repository.dictionaries.ClientEntityRepository;
import hackathon.model.dictionaries.Client;
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonApplication.class)
@AutoConfigureMockMvc
public class ClientControllerTest {

    private static final String CLIENT_PATH = "/dictionaries/clients";

    @Autowired
    private ClientEntityRepository clientEntityRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFindClient_notFound() throws Exception {
        clientEntityRepository.deleteAll();
        mvc.perform(MockMvcRequestBuilders.get(CLIENT_PATH.concat("/find"))
                .param("password", "test")
                .param("OMS", "test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindClient_success() throws Exception {
        String password = "password";
        String oms = "oms";
        String fullName = "fullName";
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setOms(oms);
        clientEntity.setPassword(password);
        clientEntity.setFullNaMe(fullName);
        clientEntityRepository.save(clientEntity);

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(CLIENT_PATH.concat("/find"))
                .param("password", clientEntity.getPassword())
                .param("OMS", clientEntity.getOms())
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        Client client = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                Client.class);
        assertEquals(fullName, client.getFullNaMe());
        assertEquals(oms, client.getOMS());

    }

}