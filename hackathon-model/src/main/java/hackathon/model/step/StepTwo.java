package hackathon.model.step;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public class StepTwo {

    private String appointmentTypeId;

    private String appointmentId;

    private String appointmentDate;

    private String medicTypeId;

    public String getAppointmentTypeId() {
        return appointmentTypeId;
    }

    public void setAppointmentTypeId(String appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getMedicTypeId() {
        return medicTypeId;
    }

    public void setMedicTypeId(String medicTypeId) {
        this.medicTypeId = medicTypeId;
    }
}
