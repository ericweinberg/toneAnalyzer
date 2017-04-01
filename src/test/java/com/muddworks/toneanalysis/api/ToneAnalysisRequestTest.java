package com.muddworks.toneanalysis.api;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created on 3/31/17.
 */
public class ToneAnalysisRequestTest {
    @Test
    public void testConstructor() {
       ToneAnalysisRequest request = new ToneAnalysisRequest("Hello");
       assertThat(request.getText(), is("Hello"));
    }
}
