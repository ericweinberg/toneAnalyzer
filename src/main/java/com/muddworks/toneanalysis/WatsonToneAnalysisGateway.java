package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.springframework.stereotype.Component;

/**
 * Created on 4/1/17.
 */
@Component
public class WatsonToneAnalysisGateway implements ToneAnalysisGateway {

    @Override
    public ToneAnalysis analyzeTone(String text) {
        return new ToneAnalysis(1.0, 43.3);
    }
}
