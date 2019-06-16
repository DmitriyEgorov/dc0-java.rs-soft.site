package hackathon.controller.dictionaries;

import hackathon.model.dictionaries.Polyclinic;
import hackathon.processor.dictionaries.PolyclinicProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@RestController
@RequestMapping("/dictionaries/cities")
public class CityController {
    private static final Log LOGGER = LogFactory.getLog(CityController.class);

    private final PolyclinicProcessor polyclinicProcessor;

    public CityController(PolyclinicProcessor polyclinicProcessor) {
        this.polyclinicProcessor = polyclinicProcessor;
    }

    @GetMapping("/{cityId}/polyclinics")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Polyclinic>> findListPolyclinicsByCityId(@PathVariable("cityId") Long cityId) {
        try {
            return ResponseEntity.ok(polyclinicProcessor.findListPolyclinicsByCityId(cityId));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
