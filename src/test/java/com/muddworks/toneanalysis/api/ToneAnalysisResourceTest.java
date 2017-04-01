package com.muddworks.toneanalysis.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muddworks.toneanalysis.ToneAnalysisService;
import com.muddworks.toneanalysis.configuration.Application;
import com.muddworks.toneanalysis.domain.ToneAnalysis;
import com.muddworks.toneanalysis.domain.ToneAnalysisFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 3/31/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ToneAnalysisResourceTest {

    @Mock
    private ToneAnalysisService toneAnalysisService;

    @InjectMocks
    private ToneAnalysisResource resource;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(resource).build();
    }

    @Test
    public void testCreateToneAnalysis() throws Exception {
        ToneAnalysis expected = ToneAnalysisFactory.createToneAnalysis();
        when(toneAnalysisService.analyzeTone("Hello world")).thenReturn(expected);

        ResultActions actions = mvc.perform(MockMvcRequestBuilders.post("/toneAnalysis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writer().writeValueAsString(new ToneAnalysisRequest("Hello world"))))
                .andExpect(status().isOk());

        String json = actions.andReturn().getResponse().getContentAsString();

        ToneAnalysis actual = mapper.readValue(json, ToneAnalysis.class);
        assertThat(actual, is(expected));
    }
}
