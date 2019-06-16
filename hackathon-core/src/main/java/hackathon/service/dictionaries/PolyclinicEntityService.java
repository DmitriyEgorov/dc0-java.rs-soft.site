package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.PolyclinicEntity;
import hackathon.db.repository.dictionaries.PolyclinicEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class PolyclinicEntityService {

    private final PolyclinicEntityRepository polyclinicEntityRepository;

    public PolyclinicEntityService(PolyclinicEntityRepository polyclinicEntityRepository) {
        this.polyclinicEntityRepository = polyclinicEntityRepository;
    }

    public List<PolyclinicEntity> findListPolyclinicsByCityId(Long id) {
        return polyclinicEntityRepository.findByCityId(id);
    }
}
