package com.example.bestfit.controllers;

import com.example.bestfit.models.ProcessAllocation;
import com.example.bestfit.services.BestFitAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bestfit")
public class BestFit {


    @PostMapping
    @ResponseBody
    public ResponseEntity<List<ProcessAllocation>> getProcessAllocation(@RequestBody @RequestParam(name = "processes[]") int[] processes,
                                                                       @RequestBody @RequestParam(name = "blocks[]") int[] blocks) {
        return ResponseEntity.ok(BestFitAlgorithm.bestFit(blocks, blocks.length, processes, processes.length));
    }

    @GetMapping
    public String getBestFitPage() {
        return "BestFit";
    }

}
