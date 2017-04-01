package com.muddworks.toneanalysis.domain;

import java.util.Objects;

/**
 * Scores under .5 are unlikely to be perceived.
 * <p>
 * Created on 4/1/17.
 */
public class EmotionalTone {
    private double joy;
    private double fear;
    private double sadness;
    private double disgust;
    private double anger;

    protected EmotionalTone() {
    }

    public EmotionalTone(double joy, double fear, double sadness, double disgust, double anger) {
        this.joy = joy;
        this.fear = fear;
        this.sadness = sadness;
        this.disgust = disgust;
        this.anger = anger;
    }

    public double getJoy() {
        return joy;
    }

    public double getFear() {
        return fear;
    }

    public double getSadness() {
        return sadness;
    }

    public double getDisgust() {
        return disgust;
    }

    public double getAnger() {
        return anger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmotionalTone that = (EmotionalTone) o;
        return Double.compare(that.joy, joy) == 0 &&
                Double.compare(that.fear, fear) == 0 &&
                Double.compare(that.sadness, sadness) == 0 &&
                Double.compare(that.disgust, disgust) == 0 &&
                Double.compare(that.anger, anger) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(joy, fear, sadness, disgust, anger);
    }

    @Override
    public String toString() {
        return "EmotionalTone{" +
                "joy=" + joy +
                ", fear=" + fear +
                ", sadness=" + sadness +
                ", disgust=" + disgust +
                ", anger=" + anger +
                '}';
    }
}
