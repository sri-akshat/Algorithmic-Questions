package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoGeometry {
    @JsonProperty("bounds")
    private GoogleGeoBounds bounds;

    public GoogleGeoLatLng getLocation() {
        return location;
    }
    @JsonProperty("location")
    private GoogleGeoLatLng location;
    @JsonProperty("location_type")
    private String location_type;
    @JsonProperty("viewport")
    private GoogleGeoBounds viewport;
}