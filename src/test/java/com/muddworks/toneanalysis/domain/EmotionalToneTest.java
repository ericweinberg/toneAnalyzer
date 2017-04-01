package com.muddworks.toneanalysis.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 4/1/17.
 */
public class EmotionalToneTest {

    @Test
    public void testConstructor() {
        double expectedJoy = .001;
        double expectedFear = .433;
        double expectedSadness = .874;
        double expectedDisgust = .2157;
        double expectedAnger = 1.0;

        EmotionalTone tone = new EmotionalTone(expectedJoy, expectedFear, expectedSadness, expectedDisgust,
                expectedAnger);

        assertThat(tone.getFear(), is(expectedFear));
        assertThat(tone.getJoy(), is(expectedJoy));
        assertThat(tone.getAnger(), is(expectedAnger));
        assertThat(tone.getDisgust(), is(expectedDisgust));
        assertThat(tone.getSadness(), is(expectedSadness));
    }
}
