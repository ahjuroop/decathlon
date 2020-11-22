package eu.ndrez.deca.service;

import eu.ndrez.deca.constants.DecathlonEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
public class DecathlonService {

    public Map<DecathlonEvent, Integer> processResults(Map<DecathlonEvent, Double> results) {
        if (results.size() != DecathlonEvent.values().length) {
            log.warn("Incorrect number of events present in the request: {}", results);
        }
        return results.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                eventResult -> eventResult.getKey().calculatePoints(eventResult.getValue())
                        )
                );
    }
}
