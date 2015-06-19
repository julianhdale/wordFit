package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by juliandale on 6/18/15.
 */
public class SaveTextPayload {

    @JsonProperty("terms")
    public String[] terms;

}
