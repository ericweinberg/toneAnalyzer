package com.muddworks.toneanalysis.api;

import java.util.Objects;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysisRequest {
    private String text;

    protected ToneAnalysisRequest() {

    }

    public ToneAnalysisRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToneAnalysisRequest that = (ToneAnalysisRequest) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "ToneAnalysisRequest{" +
                "text='" + text + '\'' +
                '}';
    }
}
