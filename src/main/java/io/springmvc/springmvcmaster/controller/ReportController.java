package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Report;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @GetMapping(produces = "application/json")
    public Map<String, Report> getReport(@RequestBody Report report) {
        return Map.of("report", report);
    }

    @PostMapping(consumes = "application/json")
    public Map<String, Report> postReport(@RequestBody Report report) {
        return Map.of("report", report);
    }
}
