package com.muddworks.toneanalysis.api;

import com.muddworks.toneanalysis.ToneAnalysisService;
import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for interacting with tone analyses.
 * <p>
 * Created on 3/31/17.
 */
@RequestMapping("/toneAnalysis")
@RestController
public class ToneAnalysisResource {

    private static Logger logger = LoggerFactory.getLogger(ToneAnalysisResource.class);

    private ToneAnalysisService service;

    @Autowired
    public ToneAnalysisResource(ToneAnalysisService service) {
        this.service = service;
    }

    @PostMapping()
    public ToneAnalysis createToneAnalysis(@RequestBody ToneAnalysisRequest request) {
        logger.debug("POST: /toneAnalysis [{}]", request.getText());
        return service.analyzeTone(request.getText());
    }
}
