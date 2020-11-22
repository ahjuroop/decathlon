package eu.ndrez.deca.controller.rest;

import eu.ndrez.deca.constants.DecathlonEvent;
import eu.ndrez.deca.model.DecathlonEventResponseDto;
import eu.ndrez.deca.model.DecathlonScoreRequestDto;
import eu.ndrez.deca.model.DecathlonScoreResponseDto;
import eu.ndrez.deca.service.DecathlonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DecathlonController {

    private final DecathlonService decathlonService;

    @GetMapping("/events")
    public List<DecathlonEventResponseDto> getEvents() {
        return Arrays.stream(DecathlonEvent.values())
                .map(DecathlonEventResponseDto::fromEnum)
                .collect(Collectors.toList());
    }

    @PostMapping("/results")
    public DecathlonScoreResponseDto processResults(@RequestBody DecathlonScoreRequestDto results) {
        var scores = decathlonService.processResults(results.getResults());
        return DecathlonScoreResponseDto.builder()
                .scoreRefNum(-1L) // no database for now
                .calculatedScores(scores)
                .build();
    }

}
