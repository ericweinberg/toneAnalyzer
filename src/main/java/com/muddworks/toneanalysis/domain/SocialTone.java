package com.muddworks.toneanalysis.domain;

import java.util.Objects;

/**
 * Categories are from the Big Five personality model.
 * <p>
 * Created on 4/1/17.
 */
public class SocialTone {
    private double openness;
    private double conscientiousness;
    private double extraversion;
    private double agreeableness;
    private double emotionalRange;

    protected SocialTone() {
    }

    public SocialTone(double openness, double conscientiousness, double extraversion, double agreeableness,
                      double emotionalRange) {
        this.openness = openness;
        this.conscientiousness = conscientiousness;
        this.extraversion = extraversion;
        this.agreeableness = agreeableness;
        this.emotionalRange = emotionalRange;
    }

    public double getOpenness() {
        return openness;
    }

    public double getConscientiousness() {
        return conscientiousness;
    }

    public double getExtraversion() {
        return extraversion;
    }

    public double getAgreeableness() {
        return agreeableness;
    }

    public double getEmotionalRange() {
        return emotionalRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialTone that = (SocialTone) o;
        return Double.compare(that.openness, openness) == 0 &&
                Double.compare(that.conscientiousness, conscientiousness) == 0 &&
                Double.compare(that.extraversion, extraversion) == 0 &&
                Double.compare(that.agreeableness, agreeableness) == 0 &&
                Double.compare(that.emotionalRange, emotionalRange) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(openness, conscientiousness, extraversion, agreeableness, emotionalRange);
    }

    @Override
    public String toString() {
        return "SocialTone{" +
                "openness=" + openness +
                ", conscientiousness=" + conscientiousness +
                ", extraversion=" + extraversion +
                ", agreeableness=" + agreeableness +
                ", emotionalRange=" + emotionalRange +
                '}';
    }
}
