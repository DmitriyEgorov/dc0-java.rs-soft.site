package hackathon.db.repository.dictionaries;

import hackathon.db.model.dictionaries.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository for client's data
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByLoginAndPassword(String login, String Oms);

}
