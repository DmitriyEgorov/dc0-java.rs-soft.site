package hackathon.adapter.dictionaries;

import hackathon.db.model.dictionaries.PolyclinicEntity;
import hackathon.model.dictionaries.Polyclinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy
 * @since 15.06.2019
 */
public class PolyclinicAdapter {

    public static List<Polyclinic> adaptPolyclinics(List<PolyclinicEntity> polyclinicEntities) {
        return polyclinicEntities == null ?
                new ArrayList<>() :
                polyclinicEntities.stream().map(PolyclinicAdapter::adaptPolyclinic)
                        .collect(Collectors.toList());
    }

    private static Polyclinic adaptPolyclinic(PolyclinicEntity polyclinicEntity) {
        Polyclinic polyclinic = new Polyclinic();
        polyclinic.setId(polyclinicEntity.getId());
        polyclinic.setName(polyclinicEntity.getName());
        return polyclinic;
    }
}
