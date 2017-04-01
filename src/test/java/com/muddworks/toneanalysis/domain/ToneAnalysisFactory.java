package com.muddworks.toneanalysis.domain;

/**
 * Created on 4/1/17.
 */
public class ToneAnalysisFactory {

    public static ToneAnalysis createToneAnalysis() {
        return new ToneAnalysis("hello world", createEmotionalTone(), createSocialTone(), createLanguageTone());
    }

    public static EmotionalTone createEmotionalTone() {
        return new EmotionalTone(.001, .004, .6423, .42, .86);
    }

    public static SocialTone createSocialTone() {
        return new SocialTone(.35, .94, .12, .59, 1.0);
    }

    public static LanguageTone createLanguageTone() {
        return new LanguageTone(.52, .642, .92);
    }
}
