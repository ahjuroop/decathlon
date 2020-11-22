package eu.ndrez.deca.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static eu.ndrez.deca.constants.DecathlonEvent.EventType.FIELD;
import static eu.ndrez.deca.constants.DecathlonEvent.EventType.TRACK;

@Getter
@RequiredArgsConstructor
public enum DecathlonEvent {

    _100_M("100 m", 25.4347, 18, 1.81, TRACK, "s"),
    LONG_JUMP("Long jump", 0.14354, 220, 1.4, FIELD, "cm"),
    SHOT_PUT("Shot put", 51.39, 1.5, 1.05, FIELD, "m"),
    HIGH_JUMP("High jump", 0.8465, 75, 1.42, FIELD, "cm"),
    _400_M("400 m", 1.53775, 82, 1.81, TRACK, "s"),
    _110_M_HURDLES("110 m hurdles", 5.74352, 28.5, 1.92, TRACK, "s"),
    DISCUS_THROW("Discus throw", 12.91, 4, 1.1, FIELD, "m"),
    POLE_VAULT("Pole vault", 0.2797, 100, 1.35, FIELD, "cm"),
    JAVELIN_THROW("Javelin throw", 10.14, 7, 1.08, FIELD, "m"),
    _1500_M("1500 m", 0.03768, 480, 1.85, TRACK, "s");

    enum EventType {
        TRACK,
        FIELD
    }

    private final String eventName;
    private final double A;
    private final double B;
    private final double C;
    private final EventType eventType;
    private final String measurement;

    public int calculatePoints(double P) {
        if (eventType == TRACK) {
            return (int) (A * Math.pow(B - P, C));
        }
        return (int) (A * Math.pow(P - B, C));
    }
}
