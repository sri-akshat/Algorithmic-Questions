package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoCode {
    @JsonProperty("status")
    String status;

    public GoogleGeoResult[] getResults() {
        return results;
    }
    @JsonProperty("results")
    private GoogleGeoResult [] results;
    @JsonProperty("exclude_from_slo")
    private Boolean exclude_from_slo;
    @JsonProperty("error_message")
    String error_message;
}