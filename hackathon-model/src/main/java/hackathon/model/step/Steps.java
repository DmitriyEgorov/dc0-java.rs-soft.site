package hackathon.model.step;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
public class Steps {

    private String userId;

    private StepOne stepOne;

    private StepTwo stepTwo;

    private StepThree stepThree;

    private StepFour stepFour;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public StepOne getStepOne() {
        return stepOne;
    }

    public void setStepOne(StepOne stepOne) {
        this.stepOne = stepOne;
    }

    public StepTwo getStepTwo() {
        return stepTwo;
    }

    public void setStepTwo(StepTwo stepTwo) {
        this.stepTwo = stepTwo;
    }

    public StepThree getStepThree() {
        return stepThree;
    }

    public void setStepThree(StepThree stepThree) {
        this.stepThree = stepThree;
    }

    public StepFour getStepFour() {
        return stepFour;
    }

    public void setStepFour(StepFour stepFour) {
        this.stepFour = stepFour;
    }
}
