package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by juliandale on 6/19/15.
 */
public class WordCountPayload {

    @JsonProperty("totalWordCount")
    public int[] totalWordCount;

    @JsonProperty("topWords")
    public WordCountModel[] topWords;

    public void setTotalWordCount(int[] array) {
        totalWordCount = array;
    }

    public void setTopWords(WordCountModel[] array) {
        topWords = array;
    }
}
