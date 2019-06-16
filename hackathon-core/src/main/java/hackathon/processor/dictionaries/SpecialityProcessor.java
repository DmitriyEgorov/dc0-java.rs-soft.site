package hackathon.processor.dictionaries;

import hackathon.model.dictionaries.Speciality;
import hackathon.service.dictionaries.SpecialityEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

import static hackathon.adapter.dictionaries.SpecialityAdapter.adaptSpecialities;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@Service
public class SpecialityProcessor {

    private final SpecialityEntityService specialityEntityService;

    public SpecialityProcessor(SpecialityEntityService specialityEntityService) {
        this.specialityEntityService = specialityEntityService;
    }

    public List<Speciality> findByPolyclinicId (Long id) {
        return adaptSpecialities(specialityEntityService.findByPolyclinicId(id));
    }

}
