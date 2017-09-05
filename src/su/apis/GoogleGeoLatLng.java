package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoLatLng {
    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;
}