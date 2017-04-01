package com.muddworks.toneanalysis.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 4/1/17.
 */
public class LanguageToneTest {

    @Test
    public void testConstructor() {
        double expectedAnalytical = .45;
        double expectedConfidence = .874;
        double expectedTentativeness = .012;

        LanguageTone tone = new LanguageTone(expectedAnalytical, expectedConfidence, expectedTentativeness);
        assertThat(tone.getAnalytical(), is(expectedAnalytical));
        assertThat(tone.getConfidence(), is(expectedConfidence));
        assertThat(tone.getTentative(), is(expectedTentativeness));
    }
}
