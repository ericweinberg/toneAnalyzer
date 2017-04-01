package com.muddworks.toneanalysis.domain;

import java.util.Objects;

/**
 * Created on 3/31/17.
 */
public class ToneAnalysis {
    private EmotionalTone emotionalTone;
    private SocialTone socialTone;
    private LanguageTone languageTone;
    private String text;


    private ToneAnalysis() {
    }

    public ToneAnalysis(String text, EmotionalTone emotionalTone, SocialTone socialTone, LanguageTone languageTone) {
        this.text = text;
        this.emotionalTone = emotionalTone;
        this.socialTone = socialTone;
        this.languageTone = languageTone;
    }

    public EmotionalTone getEmotionalTone() {
        return emotionalTone;
    }

    public SocialTone getSocialTone() {
        return socialTone;
    }

    public LanguageTone getLanguageTone() {
        return languageTone;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToneAnalysis that = (ToneAnalysis) o;
        return Objects.equals(emotionalTone, that.emotionalTone) &&
                Objects.equals(socialTone, that.socialTone) &&
                Objects.equals(languageTone, that.languageTone) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emotionalTone, socialTone, languageTone, text);
    }

    @Override
    public String toString() {
        return "ToneAnalysis{" +
                "emotionalTone=" + emotionalTone +
                ", socialTone=" + socialTone +
                ", languageTone=" + languageTone +
                ", text='" + text + '\'' +
                '}';
    }
}
