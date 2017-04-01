package com.muddworks.toneanalysis.domain;

import java.util.Objects;

/**
 * Describes the perceived writing style.
 * <p>
 * Created on 4/1/17.
 */
public class LanguageTone {
    private double analytical;
    private double confidence;
    private double tentative;

    protected LanguageTone() {
    }

    public LanguageTone(double analytical, double confidence, double tentative) {
        this.analytical = analytical;
        this.confidence = confidence;
        this.tentative = tentative;
    }

    public double getAnalytical() {
        return analytical;
    }

    public double getConfidence() {
        return confidence;
    }

    public double getTentative() {
        return tentative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageTone that = (LanguageTone) o;
        return Double.compare(that.analytical, analytical) == 0 &&
                Double.compare(that.confidence, confidence) == 0 &&
                Double.compare(that.tentative, tentative) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(analytical, confidence, tentative);
    }

    @Override
    public String toString() {
        return "LanguageTone{" +
                "analytical=" + analytical +
                ", confidence=" + confidence +
                ", tentative=" + tentative +
                '}';
    }
}
