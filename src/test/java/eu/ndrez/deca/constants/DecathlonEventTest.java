package eu.ndrez.deca.constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static eu.ndrez.deca.constants.DecathlonEvent.*;

class DecathlonEventTest {

    private static final Map<DecathlonEvent, Double> THOUSAND_PTS_BENCHMARKS = Map.of(
            _100_M, 10.395,
            LONG_JUMP, 776.0,
            SHOT_PUT, 18.4,
            HIGH_JUMP, 220.0,
            _400_M, 46.17,
            _110_M_HURDLES, 13.8,
            DISCUS_THROW, 56.17,
            POLE_VAULT, 528.0,
            JAVELIN_THROW, 77.19,
            _1500_M, 233.79
    );

    @Test
    public void testCalculation() {
        // 10pts error margin because the calculated values are not exactly 1000pts for some reason
        // https://en.wikipedia.org/wiki/Decathlon#Benchmarks
        THOUSAND_PTS_BENCHMARKS.forEach((key, value)
                -> Assertions.assertEquals(1000, key.calculatePoints(value), 10, key.getEventName()));
    }

}
