package hackathon.model.step;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public class StepThree {

    private String appointmentDateActual;

    private String medicName;

    private Meta meta;

    public String getAppointmentDateActual() {
        return appointmentDateActual;
    }

    public void setAppointmentDateActual(String appointmentDateActual) {
        this.appointmentDateActual = appointmentDateActual;
    }

    public String getMedicName() {
        return medicName;
    }

    public void setMedicName(String medicName) {
        this.medicName = medicName;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
