package eu.ndrez.deca;

import eu.ndrez.deca.constants.DecathlonEvent;
import eu.ndrez.deca.controller.rest.DecathlonController;
import eu.ndrez.deca.model.DecathlonScoreRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

import static eu.ndrez.deca.constants.DecathlonEvent.HIGH_JUMP;

@SpringBootTest
class DecaApplicationTests {

    @Resource
    private DecathlonController controller;

    @Test
    void contextLoads() {
        //TODO restassured instead of controller testing
    }

    @Test
    void testGetEvents() {
        var response = controller.getEvents();
        Assertions.assertEquals(DecathlonEvent.values().length, response.size());
        response.forEach(event -> DecathlonEvent.valueOf(event.getCode()));
    }

    @Test
    void testProcessResults() {
        var request = new DecathlonScoreRequestDto();
        request.setResults(Map.of(
                DecathlonEvent._100_M, 10.395,
                HIGH_JUMP, 220.0
        ));
        var response = controller.processResults(request).getCalculatedScores();
        Assertions.assertEquals(request.getResults().size(), response.size());
        response.values().forEach(Assertions::assertNotNull);
    }

}
