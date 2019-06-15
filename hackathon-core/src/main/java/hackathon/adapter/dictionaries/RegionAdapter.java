package hackathon.adapter.dictionaries;

import hackathon.db.model.dictionaries.RegionEntity;
import hackathon.model.dictionaries.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public class RegionAdapter {

    public static List<Region> adaptRegions(List<RegionEntity> regionEntities) {
        return regionEntities == null ?
                new ArrayList<>() :
                regionEntities.stream().map(RegionAdapter::adaptRegion)
                .collect(Collectors.toList());

    }

    private static Region adaptRegion (RegionEntity regionEntity) {
        Region region = new Region();
        region.setId(regionEntity.getId());
        region.setRegionName(regionEntity.getRegionName());
        return region;
    }
}
