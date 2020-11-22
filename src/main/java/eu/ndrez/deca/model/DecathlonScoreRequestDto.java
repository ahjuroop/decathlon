package eu.ndrez.deca.model;

import eu.ndrez.deca.constants.DecathlonEvent;
import lombok.Data;

import java.util.Map;

@Data
public class DecathlonScoreRequestDto {

    private Map<DecathlonEvent, Double> results;
}
