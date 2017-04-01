package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.springframework.stereotype.Service;

/**
 * Created on 3/31/17.
 */
@Service
public class ToneAnalysisService {

    public ToneAnalysis analyzeTone(String text) {
        return new ToneAnalysis(1.0, 43.3);
    }
}
