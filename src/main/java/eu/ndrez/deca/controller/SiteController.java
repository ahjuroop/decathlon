package eu.ndrez.deca.controller;

import eu.ndrez.deca.constants.DecathlonEvent;
import eu.ndrez.deca.model.DecathlonScoreRequestDto;
import eu.ndrez.deca.service.DecathlonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SiteController {

    private final DecathlonService decathlonService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("decathlonEvents", DecathlonEvent.values());
        model.addAttribute("decathlonScoreRequest", new DecathlonScoreRequestDto());
        return "index";
    }

    @PostMapping("/results")
    public String results(@ModelAttribute DecathlonScoreRequestDto decathlonScoreRequest, Model model) {
        var results = decathlonService.processResults(decathlonScoreRequest.getResults());
        int total = results.values().stream().mapToInt(Integer::intValue).sum();

        model.addAttribute("decathlonScoreResponse", results);
        model.addAttribute("decathlonScoreTotal", total);
        return "results";
    }
}
