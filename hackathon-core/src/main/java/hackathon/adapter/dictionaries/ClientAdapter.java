package hackathon.adapter.dictionaries;

import hackathon.db.model.dictionaries.ClientEntity;
import hackathon.model.dictionaries.Client;

/**
 * adapter for client's data
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
public class ClientAdapter {

    /**
     * adapt client's data
     *
     * @param clientEntity - client' data from DB
     * @return - client's data for presentation
     */
    public static Client adaptClient(ClientEntity clientEntity) {
        Client client = new Client();
        client.setFullNaMe(clientEntity.getFullNaMe());
        client.setOMS(clientEntity.getOms());
        return client;
    }
}
