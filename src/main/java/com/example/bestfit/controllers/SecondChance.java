package com.example.bestfit.controllers;

import com.example.bestfit.services.SecondChanceAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secondchance")
public class SecondChance {

    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> getProcessAllocation(@RequestBody @RequestParam(name = "processes") String processes,
                                                        @RequestBody @RequestParam(name = "frames") int frames) {
        Integer faults = SecondChanceAlgorithm.printHitsAndFaults(processes, frames);
        return ResponseEntity.ok(faults);
    }

    @GetMapping
    public String getBestFitPage() {
        return "SecondChance";
    }


}
