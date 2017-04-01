package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 3/31/17.
 */
@Service
public class ToneAnalysisService {
    private ToneAnalysisGateway gateway;

    @Autowired
    public ToneAnalysisService(ToneAnalysisGateway gateway) {
        this.gateway = gateway;
    }

    public ToneAnalysis analyzeTone(String text) {
        return gateway.analyzeTone(text);
    }
}
