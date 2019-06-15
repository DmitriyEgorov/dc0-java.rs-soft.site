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
    private static final String NOT_FOUND_MESSAGE = "client with id password %s and OMS %s not found";

    private final ClientEntityRepository clientEntityRepository;

    public ClientEntityService(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    public ClientEntity findClientByPasswordAndOMS(String password, String OMS) throws ClientEntityNotFoundException {
        ClientEntity clientEntity =  clientEntityRepository.findByPasswordAndOms(password, OMS);
        if(clientEntity == null) {
            throw new ClientEntityNotFoundException(String.format(NOT_FOUND_MESSAGE, password, OMS));
        }
        return clientEntity;
    }
}
