package com.muddworks.toneanalyzer.api;

import com.muddworks.toneanalyzer.domain.ToneAnalysis;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for interacting with tone analyses.
 *
 * Created on 3/31/17.
 */
@RequestMapping("/toneAnalysis")
@RestController
public class ToneAnalysisResource {

    @PostMapping
    public ToneAnalysis createToneAnalysis() {
        return new ToneAnalysis(1.0, 43.3);
    }
}
