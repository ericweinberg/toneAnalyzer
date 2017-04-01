package com.muddworks.toneanalysis.api;

import com.muddworks.toneanalysis.ToneAnalysisService;
import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static Logger logger = LoggerFactory.getLogger(ToneAnalysisResource.class);

    private ToneAnalysisService service;

    @Autowired
    public ToneAnalysisResource(ToneAnalysisService service) {
        this.service = service;
    }

    @PostMapping
    public ToneAnalysis createToneAnalysis(ToneAnalysisRequest request) {
        logger.debug("POST: /toneAnalysis");
        return service.analyzeTone(request.getText());

    }
}
