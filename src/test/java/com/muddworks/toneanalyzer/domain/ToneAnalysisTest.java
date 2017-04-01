package com.muddworks.toneanalyzer.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysisTest {

    @Test
    public void testConstructor() {
        ToneAnalysis toneAnalysis = new ToneAnalysis(23.1, 423.2);
        assertThat(toneAnalysis.getAnger(), is(23.1));
        assertThat(toneAnalysis.getHappiness(), is(423.2));
    }
}
