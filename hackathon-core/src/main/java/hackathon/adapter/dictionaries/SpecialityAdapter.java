package hackathon.adapter.dictionaries;

import hackathon.db.model.dictionaries.SpecialityEntity;
import hackathon.model.dictionaries.Speciality;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public class SpecialityAdapter {

    public static List<Speciality> adaptSpecialities(List<SpecialityEntity> specialityEntities) {
        return specialityEntities == null ?
                new ArrayList<>() :
                specialityEntities.stream().map(SpecialityAdapter::adaptSpeciality)
                .collect(Collectors.toList());

    }

    private static Speciality adaptSpeciality(SpecialityEntity specialityEntity) {
        Speciality speciality = new Speciality();
        speciality.setName(specialityEntity.getName());
        return speciality;
    }

}
