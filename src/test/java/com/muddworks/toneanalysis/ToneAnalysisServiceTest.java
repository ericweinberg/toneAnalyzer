package com.muddworks.toneanalysis;

import com.muddworks.toneanalysis.domain.ToneAnalysis;
import com.muddworks.toneanalysis.domain.ToneAnalysisFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created on 3/31/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ToneAnalysisServiceTest {

    @Mock
    private ToneAnalysisGateway gateway;
    @InjectMocks
    private ToneAnalysisService service;

    @Test
    public void testAnalyzeTone() {
        ToneAnalysis toneAnalysis = ToneAnalysisFactory.createToneAnalysis();
        when(gateway.analyzeTone("Anything can go here")).thenReturn(toneAnalysis);
        ToneAnalysis result = service.analyzeTone("Anything can go here");
        assertThat(result, is(toneAnalysis));
    }
}
