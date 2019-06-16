package hackathon.controller.step;

import app.config.TestHackathonApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.model.step.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 16.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonApplication.class)
@AutoConfigureMockMvc
public class StepControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_ping() throws Exception{
        Steps steps = new Steps();

        StepOne stepOne = new StepOne();
        stepOne.setSymptoms("Symptoms");
        stepOne.setDiagnosisId(1L);
        stepOne.setPolyclinicId(1L);

        StepTwo stepTwo = new StepTwo();
        stepTwo.setAppointmentDate(LocalDateTime.now().toString());
        stepTwo.setAppointmentId("1");
        stepTwo.setAppointmentTypeId("1");
        stepTwo.setMedicTypeId("1");

        StepThree stepThree = new StepThree();
        stepThree.setAppointmentDateActual(LocalDateTime.now().toString());
        stepThree.setMedicName("name");
        Meta meta = new Meta();
        meta.setBloodPressure(true);
        meta.setInspection(true);
        meta.setTemperature(true);
        stepThree.setMeta(meta);

        StepFour stepFour = new StepFour();
        stepFour.setNeatness(1);
        stepFour.setPoliteness(2);
        stepFour.setTechnicalState(3);

        steps.setUserId("1");
        steps.setStepOne(stepOne);
        steps.setStepTwo(stepTwo);
        steps.setStepThree(stepThree);
        steps.setStepFour(stepFour);


        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/step")
                .content(mapper.writeValueAsString(steps))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());
    }

}