package su.apis;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GoogleGeoAdressComponent {
    @JsonProperty("long_name")
    private String long_name;
    @JsonProperty("short_name")
    private String short_name;
    @JsonProperty("types")
    private String [] types;
}