package com.muddworks.toneanalysis.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysisTest {

    @Test
    public void testConstructor() {
        ToneAnalysis toneAnalysis = ToneAnalysisFactory.createToneAnalysis();
        assertThat(toneAnalysis.getEmotionalTone(), is(ToneAnalysisFactory.createEmotionalTone()));
        assertThat(toneAnalysis.getLanguageTone(), is(ToneAnalysisFactory.createLanguageTone()));
        assertThat(toneAnalysis.getSocialTone(), is(ToneAnalysisFactory.createSocialTone()));
        assertThat(toneAnalysis.getText(), is("hello world"));

    }
}
