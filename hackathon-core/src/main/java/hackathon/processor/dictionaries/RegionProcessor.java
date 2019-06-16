package hackathon.processor.dictionaries;

import hackathon.model.dictionaries.Region;
import hackathon.service.dictionaries.RegionEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

import static hackathon.adapter.dictionaries.RegionAdapter.adaptRegions;

/**
 * processor for region
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class RegionProcessor {

    private final RegionEntityService regionEntityService;

    public RegionProcessor(RegionEntityService regionEntityService) {
        this.regionEntityService = regionEntityService;
    }

    /**
     * get list of regions
     *
     * @return list of regions
     */
    public List<Region> getRegions() {
        return adaptRegions(regionEntityService.getRegions());
    }
}
