package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysisServiceTest {

    private ToneAnalysisService service;

    @Before
    public void setUp() {
        service = new ToneAnalysisService();
    }

    @Test
    public void testAnalyzeTone() {
        ToneAnalysis result = service.analyzeTone("Anything can go here");
        assertThat(result.getAnger(), is(1.0));
        assertThat(result.getHappiness(), is(43.3));

    }
}
