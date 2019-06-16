package hackathon.controller.step;

import hackathon.model.step.Steps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@RestController
@RequestMapping("/step")
public class StepController {

    @PostMapping
    public ResponseEntity<Steps> steps(@RequestBody Steps steps) {
        return ResponseEntity.ok(steps);
    }
}
