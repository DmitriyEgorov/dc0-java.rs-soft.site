package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.ClientEntity;
import hackathon.db.repository.dictionaries.ClientEntityRepository;
import hackathon.exception.ClientEntityExistException;
import hackathon.exception.ClientEntityNotFoundException;
import hackathon.model.dictionaries.ClientDataCreation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * client's data entity in DB
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class ClientEntityService {
    private static final String NOT_FOUND_MESSAGE = "client with id login %s and password %s not found";
    private static final String EXIST_MESSAGE = "client with id login %s and password %s already exist";


    private final ClientEntityRepository clientEntityRepository;

    public ClientEntityService(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    /**
     * find client by password and OMS
     *
     * @param login    - login
     * @param password - password
     * @return client
     * @throws ClientEntityNotFoundException - when client is not found
     */
    public ClientEntity findByLoginAndPassword(String login, String password) throws ClientEntityNotFoundException {
        ClientEntity clientEntity = clientEntityRepository.findByLoginAndPassword(login, password);
        if (clientEntity == null) {
            throw new ClientEntityNotFoundException(String.format(NOT_FOUND_MESSAGE, login, password));
        }
        return clientEntity;
    }

    public ClientEntity createClient(ClientDataCreation clientDataCreation) throws ClientEntityExistException {
        checkUser(clientDataCreation);
        ClientEntity newClient = new ClientEntity();
        newClient.setLogin(clientDataCreation.getLogin());
        newClient.setPassword(clientDataCreation.getPassword());
        newClient.setFullNaMe(clientDataCreation.getFullName());
        newClient.setOms(clientDataCreation.getOms());
        newClient.setPolyclinicId(clientDataCreation.getPolyclinicId());
        newClient.setCreated_at(LocalDateTime.now());
        newClient.setEmail(clientDataCreation.getEmail());
        return clientEntityRepository.save(newClient);
    }

    private void checkUser(ClientDataCreation clientDataCreation) throws ClientEntityExistException {
        ClientEntity clientEntity = clientEntityRepository.findByLoginAndPassword(
                clientDataCreation.getLogin(),
                clientDataCreation.getPassword());
        if(clientEntity != null) {
            throw new ClientEntityExistException(String.format(
                    EXIST_MESSAGE,
                    clientDataCreation.getLogin(),
                    clientDataCreation.getPassword()));
        }
        clientEntity = clientEntityRepository.findByOms(
                clientDataCreation.getOms());
        if(clientEntity != null) {
            throw new ClientEntityExistException(String.format(
                    EXIST_MESSAGE,
                    clientDataCreation.getLogin(),
                    clientDataCreation.getPassword()));
        }
    }

}
