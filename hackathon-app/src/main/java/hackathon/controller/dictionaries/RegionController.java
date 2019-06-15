package hackathon.controller.dictionaries;

import hackathon.model.dictionaries.City;
import hackathon.model.dictionaries.Region;
import hackathon.processor.dictionaries.CityProcessor;
import hackathon.processor.dictionaries.RegionProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * controller for regions
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
@RestController
@RequestMapping("/dictionaries/regions")
public class RegionController {

    private final RegionProcessor regionProcessor;
    private final CityProcessor cityProcessor;

    public RegionController(RegionProcessor regionProcessor, CityProcessor cityProcessor) {
        this.regionProcessor = regionProcessor;
        this.cityProcessor = cityProcessor;
    }

    /**
     * get list of regions
     *
     * @return list of regions
     */
    @GetMapping
    public ResponseEntity<List<Region>> getRegions() {
        try {
            return ResponseEntity.ok(regionProcessor.getRegions());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * get list of regions
     *
     * @return list of regions
     */
    @GetMapping("/{regionId}/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<City>> getCitiesInRegions(@PathVariable("regionId") Long regionId) {
        try {
            return ResponseEntity.ok(cityProcessor.findCitiesByRegionId(regionId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
