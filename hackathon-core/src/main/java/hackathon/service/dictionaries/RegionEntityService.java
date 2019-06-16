package hackathon.service.dictionaries;

import hackathon.db.model.dictionaries.RegionEntity;
import hackathon.db.repository.dictionaries.RegionEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class RegionEntityService {

    private final RegionEntityRepository regionEntityRepository;

    public RegionEntityService(RegionEntityRepository regionEntityRepository) {
        this.regionEntityRepository = regionEntityRepository;
    }

    /**
     * get list of regions
     *
     * @return list of regions
     */
    public List<RegionEntity> getRegions() {
        return regionEntityRepository.findAll();
    }
}
