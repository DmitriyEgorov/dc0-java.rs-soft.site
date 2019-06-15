package hackathon.controller.dictionaries;

import hackathon.model.dictionaries.Speciality;
import hackathon.processor.dictionaries.SpecialityProcessor;
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
 * @author Dmitriy
 * @since 16.06.2019
 */
@RestController
@RequestMapping("/dictionaries/polyclinic")
public class PolyclinicController {

    private final SpecialityProcessor specialityProcessor;

    public PolyclinicController(SpecialityProcessor specialityProcessor) {
        this.specialityProcessor = specialityProcessor;
    }

    @GetMapping("/{polyclinicId}/specialities")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Speciality>> findListPolyclinicsByCityId(@PathVariable("polyclinicId") Long polyclinicId) {
        try {
            return ResponseEntity.ok(specialityProcessor.findByPolyclinicId(polyclinicId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
