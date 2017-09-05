package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoBounds   {
    @JsonProperty("northeast")
    private GoogleGeoLatLng northeast;
    @JsonProperty("southwest")
    private GoogleGeoLatLng southwest;
}