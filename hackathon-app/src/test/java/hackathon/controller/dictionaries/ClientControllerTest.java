package hackathon.controller.dictionaries;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.db.model.dictionaries.ClientEntity;
import hackathon.db.repository.dictionaries.ClientEntityRepository;
import hackathon.model.dictionaries.Client;
import hackathon.model.dictionaries.ClientDataCreation;
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
                .param("login", "test")
                .param("password", "test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindClient_success() throws Exception {
        clientEntityRepository.deleteAll();
        String password = "password";
        String oms = "oms";
        String fullName = "fullName";
        String login = "login";
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setOms(oms);
        clientEntity.setPassword(password);
        clientEntity.setFullNaMe(fullName);
        clientEntity.setLogin(login);
        clientEntityRepository.save(clientEntity);

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get(CLIENT_PATH.concat("/find"))
                .param("password", clientEntity.getPassword())
                .param("login", clientEntity.getLogin())
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        ObjectMapper mapper = new ObjectMapper();

        Client client = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                Client.class);
        assertEquals(fullName, client.getFullNaMe());
        assertEquals(oms, client.getOMS());
    }

    @Test
    public void testCreateClient_success() throws Exception {
        clientEntityRepository.deleteAll();
        String password = "password";
        String oms = "oms";
        String fullName = "fullName";
        String login = "login";
        ClientDataCreation clientDataCreation = new ClientDataCreation();
        clientDataCreation.setOms(oms);
        clientDataCreation.setPassword(password);
        clientDataCreation.setFullName(fullName);
        clientDataCreation.setLogin(login);

        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.put(CLIENT_PATH.concat("/create"))
                .content(mapper.writeValueAsString(clientDataCreation))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());

        Client client = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                Client.class);
        assertEquals(fullName, client.getFullNaMe());
        assertEquals(oms, client.getOMS());
    }

    @Test
    public void testCreateClient_fail_loginAndPasswordExist() throws Exception {
        clientEntityRepository.deleteAll();
        String password = "password";
        String oms = "oms";
        String fullName = "fullName";
        String login = "login";
        ClientDataCreation clientDataCreation = new ClientDataCreation();
        clientDataCreation.setOms(oms.concat("salt"));
        clientDataCreation.setPassword(password);
        clientDataCreation.setFullName(fullName);
        clientDataCreation.setLogin(login);

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setOms(oms);
        clientEntity.setPassword(password);
        clientEntity.setFullNaMe(fullName);
        clientEntity.setLogin(login);
        clientEntityRepository.save(clientEntity);

        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.put(CLIENT_PATH.concat("/create"))
                .content(mapper.writeValueAsString(clientDataCreation))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateClient_fail_OMSExists() throws Exception {
        clientEntityRepository.deleteAll();
        String password = "password";
        String oms = "oms";
        String fullName = "fullName";
        String login = "login";
        ClientDataCreation clientDataCreation = new ClientDataCreation();
        clientDataCreation.setOms(oms);
        clientDataCreation.setPassword(password.concat("salt"));
        clientDataCreation.setFullName(fullName);
        clientDataCreation.setLogin(login.concat("salt"));

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setOms(oms);
        clientEntity.setPassword(password);
        clientEntity.setFullNaMe(fullName);
        clientEntity.setLogin(login);
        clientEntityRepository.save(clientEntity);

        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.put(CLIENT_PATH.concat("/create"))
                .content(mapper.writeValueAsString(clientDataCreation))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest());
    }

}