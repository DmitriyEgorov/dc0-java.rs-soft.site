package hackathon.processor.dictionaries;

import hackathon.model.dictionaries.Polyclinic;
import hackathon.service.dictionaries.PolyclinicEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

import static hackathon.adapter.dictionaries.PolyclinicAdapter.adaptPolyclinics;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
@Service
public class PolyclinicProcessor {

    private final PolyclinicEntityService polyclinicEntityService;

    public PolyclinicProcessor(PolyclinicEntityService polyclinicEntityService) {
        this.polyclinicEntityService = polyclinicEntityService;
    }

    public List<Polyclinic> findListPolyclinicsByCityId (Long id) {
        return adaptPolyclinics(polyclinicEntityService.findListPolyclinicsByCityId(id));
    }

}
