package eu.ndrez.deca.model;

import eu.ndrez.deca.constants.DecathlonEvent;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DecathlonScoreResponseDto {

    private Long scoreRefNum;
    private Map<DecathlonEvent, Integer> calculatedScores;
}
