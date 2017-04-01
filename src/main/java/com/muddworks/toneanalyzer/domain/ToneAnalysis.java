package com.muddworks.toneanalyzer.domain;

import java.util.Objects;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysis {
    private double anger;
    private double happiness;

    private ToneAnalysis() {
    }

    public ToneAnalysis(double anger, double happiness) {
        this.anger = anger;
        this.happiness = happiness;
    }

    public double getAnger() {
        return anger;
    }

    public double getHappiness() {
        return happiness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToneAnalysis that = (ToneAnalysis) o;
        return Double.compare(that.anger, anger) == 0 &&
                Double.compare(that.happiness, happiness) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anger, happiness);
    }

    @Override
    public String toString() {
        return "ToneAnalysis{" +
                "anger=" + anger +
                ", happiness=" + happiness +
                '}';
    }
}
