package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoResult   {
    @JsonProperty("address_components")
    private GoogleGeoAdressComponent [] address_components;
    @JsonProperty("formatted_address")
    private String formatted_address;

    public GoogleGeoGeometry getGeometry() {
        return geometry;
    }
    @JsonProperty("geometry")
    private GoogleGeoGeometry geometry;
    @JsonProperty("partial_match")
    private Boolean partial_match;
    @JsonProperty("place_id")
    private String place_id;
    @JsonProperty("types")
    private String [] types;
}