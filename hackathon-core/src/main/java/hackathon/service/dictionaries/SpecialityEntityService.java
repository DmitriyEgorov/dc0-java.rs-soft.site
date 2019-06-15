package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.SpecialityEntity;
import hackathon.db.repository.dictionaries.SpecialityEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@Service
public class SpecialityEntityService {

    private final SpecialityEntityRepository specialityEntityRepository;

    public SpecialityEntityService(SpecialityEntityRepository specialityEntityRepository) {
        this.specialityEntityRepository = specialityEntityRepository;
    }

    public List<SpecialityEntity> findByPolyclinicId(Long id) {
        return specialityEntityRepository.findByPolyclinicId(id);
    }
}
