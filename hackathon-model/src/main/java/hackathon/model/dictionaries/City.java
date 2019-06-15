package hackathon.model.dictionaries;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * city's data
 *
 * @author Dmitriy
 * @since 15.06.2019
 */
public class City {

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;

        return new EqualsBuilder()
                .append(cityName, city.cityName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cityName)
                .toHashCode();
    }
}
