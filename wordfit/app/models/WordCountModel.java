package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juliandale on 6/19/15.
 */
public class WordCountModel {

    @JsonProperty("word")
    public String word;

    @JsonProperty("count")
    public int count;


    public WordCountModel(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
