package su.apis;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class GeoCodeTest {

    /**
     * Given an address asks google for geocode
     *
     * If ssl is true API_KEY should be a valid developer key (given by google)
     *
     * @param address the address to find
     * @param ssl defines if ssl should be used
     * @return the GoogleGeoCode found
     * @throws Exception in case of any error
     *
     */
    public GoogleGeoCode getGeoCode(String address, boolean ssl) throws Exception {
        // build url
        StringBuilder url = new StringBuilder("http");
        if ( ssl ) {
            url.append("s");
        }

        url.append("://maps.googleapis.com/maps/api/geocode/json?");

//        if ( ssl ) {
//            url.append("key=");
//            url.append(API_KEY);
//            url.append("&");
//        }
        url.append("sensor=false&address=");
        url.append( URLEncoder.encode(address) );

        // request url like: http://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address) + "&sensor=false"
        // do request
        try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
            HttpGet request = new HttpGet(url.toString());

            // set common headers (may useless)
            request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
            request.setHeader("Host", "maps.googleapis.com");
            request.setHeader("Connection", "keep-alive");
            request.setHeader("Accept-Language", "en-US,en;q=0.5");
            request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            request.setHeader("Accept-Encoding", "gzip, deflate");

            try (CloseableHttpResponse response = httpclient.execute(request)) {
                HttpEntity entity = response.getEntity();

                // recover String response (for debug purposes)
                StringBuilder result = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        result.append(inputLine);
                        result.append("\n");
                    }
                }
                System.out.println(result);

                // parse result
                ObjectMapper mapper = new ObjectMapper();
                GoogleGeoCode geocode = mapper.readValue(result.toString(), GoogleGeoCode.class);

                if (!"OK".equals(geocode.status)) {
                    if (geocode.error_message != null) {
                        throw new Exception(geocode.error_message);
                    }
                    throw new Exception("Can not find geocode for: " + address);
                }
                return geocode;
            }
        }
    }


}

 class GoogleGeoCode {
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

 class GoogleGeoResult   {
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

 class GoogleGeoAdressComponent {
     @JsonProperty("long_name")
    private String long_name;
     @JsonProperty("short_name")
    private String short_name;
     @JsonProperty("types")
    private String [] types;
}

 class GoogleGeoGeometry {
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

 class GoogleGeoBounds   {
     @JsonProperty("northeast")
    private GoogleGeoLatLng northeast;
     @JsonProperty("southwest")
    private GoogleGeoLatLng southwest;
}

 class GoogleGeoLatLng {
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
