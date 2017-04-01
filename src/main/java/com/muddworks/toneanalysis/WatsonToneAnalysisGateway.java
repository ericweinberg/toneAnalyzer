package com.muddworks.toneanalysis;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.muddworks.toneanalysis.domain.EmotionalTone;
import com.muddworks.toneanalysis.domain.LanguageTone;
import com.muddworks.toneanalysis.domain.SocialTone;
import com.muddworks.toneanalysis.domain.ToneAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer.VERSION_DATE_2016_05_19;

/**
 * Created on 4/1/17.
 */
@Component
public class WatsonToneAnalysisGateway implements ToneAnalysisGateway {
    private String userName;
    private String password;

    @Autowired
    public WatsonToneAnalysisGateway(@Value("${watson.toneanalyzer.username}") String userName,
                                     @Value("${watson.toneanalyzer.password}") String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public ToneAnalysis analyzeTone(String text) {
        ToneAnalyzer analyzer = new ToneAnalyzer(VERSION_DATE_2016_05_19, userName, password);

        com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis tone =
                analyzer.getTone(text, null).execute();

        ToneCategory emotion = tone.getDocumentTone().getTones().stream()
                .filter(it -> it.getName().equalsIgnoreCase("Emotion Tone"))
                .findFirst().get();
        ToneCategory social = tone.getDocumentTone().getTones().stream()
                .filter(it -> it.getName().equalsIgnoreCase("Social Tone"))
                .findFirst().get();
        ToneCategory language = tone.getDocumentTone().getTones().stream()
                .filter(it -> it.getName().equalsIgnoreCase("Language Tone"))
                .findFirst().get();

        EmotionalTone emotionalTone = convertEmotionalTone(emotion);
        SocialTone socialTone = convertSocialTone(social);
        LanguageTone languageTone = convertLanguageTone(language);

        return new ToneAnalysis(text, emotionalTone, socialTone, languageTone);
    }

    private LanguageTone convertLanguageTone(ToneCategory language) {
        return new LanguageTone(
                    language.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Analytical"))
                            .findFirst().get().getScore(),
                    language.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Confident"))
                            .findFirst().get().getScore(),
                    language.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Tentative"))
                            .findFirst().get().getScore()
            );
    }

    private SocialTone convertSocialTone(ToneCategory social) {
        return new SocialTone(
                    social.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Openness"))
                            .findFirst().get().getScore(),
                    social.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Conscientiousness"))
                            .findFirst().get().getScore(),
                    social.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Extraversion"))
                            .findFirst().get().getScore(),
                    social.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Agreeableness"))
                            .findFirst().get().getScore(),
                    social.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("Emotional Range"))
                            .findFirst().get().getScore()
            );
    }

    private EmotionalTone convertEmotionalTone(ToneCategory emotion) {
        return new EmotionalTone(
                    emotion.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("joy"))
                            .findFirst().get().getScore(),
                    emotion.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("fear"))
                            .findFirst().get().getScore(),
                    emotion.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("sadness"))
                            .findFirst().get().getScore(),
                    emotion.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("disgust"))
                            .findFirst().get().getScore(),
                    emotion.getTones().stream().filter(it -> it.getName().equalsIgnoreCase("anger"))
                            .findFirst().get().getScore()
            );
    }
}
