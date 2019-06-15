package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.ClientEntity;
import hackathon.db.repository.dictionaries.ClientEntityRepository;
import hackathon.exception.ClientEntityNotFoundException;
import org.springframework.stereotype.Service;

/**
 * client's data entity in DB
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class ClientEntityService {
    private static final String NOT_FOUND_MESSAGE = "client with id login %s and password %s not found";

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
}
