package hackathon.processor.dictionaries;

import hackathon.exception.ClientEntityNotFoundException;
import hackathon.model.dictionaries.Client;
import hackathon.service.dictionaries.ClientEntityService;
import org.springframework.stereotype.Service;

import static hackathon.adapter.ClientAdapter.adaptClient;

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

    public Client findClientByPasswordAndOMS(String password, String OMS) throws ClientEntityNotFoundException {
        return adaptClient(clientEntityService.findClientByPasswordAndOMS(password, OMS));
    }
}
