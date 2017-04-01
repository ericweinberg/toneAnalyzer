package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.springframework.stereotype.Component;

/**
 * Created on 4/1/17.
 */
@Component
public interface ToneAnalysisGateway {

    ToneAnalysis analyzeTone(String text);
}
