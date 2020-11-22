package eu.ndrez.deca.model;

import eu.ndrez.deca.constants.DecathlonEvent;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DecathlonEventResponseDto {

    private String code;
    private String name;
    private String measurement;

    public static DecathlonEventResponseDto fromEnum(DecathlonEvent event) {
        return DecathlonEventResponseDto.builder()
                .code(event.name())
                .name(event.getEventName())
                .measurement(event.getMeasurement())
                .build();
    }
}
