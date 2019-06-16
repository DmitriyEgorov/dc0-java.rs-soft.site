package hackathon.model.step;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public class Meta {

    private boolean temperature;

    private boolean bloodPressure;

    private boolean inspection;

    public boolean isTemperature() {
        return temperature;
    }

    public void setTemperature(boolean temperature) {
        this.temperature = temperature;
    }

    public boolean isBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(boolean bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public boolean isInspection() {
        return inspection;
    }

    public void setInspection(boolean inspection) {
        this.inspection = inspection;
    }
}
