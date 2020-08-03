package com.stanfordNLP.nlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {

    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma, ner, parse, sentiment";
    /*
    *tokenize for tokenizing.
    * ssplit for sentence recognition.
    * pos for parts of speech.
    * lemma for lemmatization: Identifies the root word of a particular word. Eg, Trying = try.
    * ner, Named entity recognizer.
    * parse, sentiment for sentiment analysis. Eg positive, neutral, negative energy in a string.
     */

    private Pipeline(){

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline(){
        if(stanfordCoreNLP == null)
            stanfordCoreNLP = new StanfordCoreNLP(properties);

        return stanfordCoreNLP;
    }
}
