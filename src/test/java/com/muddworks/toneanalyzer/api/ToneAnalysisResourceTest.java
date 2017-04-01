package com.muddworks.toneanalyzer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muddworks.toneanalyzer.configuration.Application;
import com.muddworks.toneanalyzer.domain.ToneAnalysis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 3/31/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ToneAnalysisResourceTest {

    @Autowired
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCreateToneAnalysis() throws Exception {
        ToneAnalysis expected = new ToneAnalysis(1.0, 43.3);
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.post("/toneAnalysis")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String json = actions.andReturn().getResponse().getContentAsString();

        ToneAnalysis actual = mapper.readValue(json, ToneAnalysis.class);
        assertThat(actual, is(expected));
    }
}
