package com.muddworks.toneanalysis.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 4/1/17.
 */
public class SocialToneTest {

    @Test
    public void testConstructor() {
        double expectedOpenness = .001;
        double expectedConscientiousness = .433;
        double expectedExtraversion = .874;
        double expectedAgreeableness = .2157;
        double expectedEmotionalRange = 1.0;

        SocialTone tone = new SocialTone(expectedOpenness, expectedConscientiousness, expectedExtraversion,
                expectedAgreeableness, expectedEmotionalRange);

        assertThat(tone.getAgreeableness(), is(expectedAgreeableness));
        assertThat(tone.getConscientiousness(), is(expectedConscientiousness));
        assertThat(tone.getEmotionalRange(), is(expectedEmotionalRange));
        assertThat(tone.getExtraversion(), is(expectedExtraversion));
        assertThat(tone.getOpenness(), is(expectedOpenness));
    }
}
