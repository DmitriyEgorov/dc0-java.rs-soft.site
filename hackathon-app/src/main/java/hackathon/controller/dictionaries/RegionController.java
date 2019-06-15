package hackathon.controller.dictionaries;

import hackathon.model.dictionaries.Region;
import hackathon.processor.dictionaries.RegionProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public RegionController(RegionProcessor regionProcessor) {
        this.regionProcessor = regionProcessor;
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
}
