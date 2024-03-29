package hackathon.processor.dictionaries;

import hackathon.exception.ClientEntityExistException;
import hackathon.exception.ClientEntityNotFoundException;
import hackathon.model.dictionaries.Client;
import hackathon.model.dictionaries.ClientDataCreation;
import hackathon.service.dictionaries.ClientEntityService;
import org.springframework.stereotype.Service;

import static hackathon.adapter.dictionaries.ClientAdapter.adaptClient;

/**
 * service for client's data
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class ClientProcessor {

    private final ClientEntityService clientEntityService;

    public ClientProcessor(ClientEntityService clientEntityService) {
        this.clientEntityService = clientEntityService;
    }

    public Client findByLoginAndPassword(String login, String password) throws ClientEntityNotFoundException {
        return adaptClient(clientEntityService.findByLoginAndPassword(login, password));
    }

    public Client createClient(ClientDataCreation clientDataCreation) throws ClientEntityExistException {
        return adaptClient(clientEntityService.createClient(clientDataCreation));
    }
}
