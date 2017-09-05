package su.apis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asrivastava6 on 2/26/16.
 */
public class TestGeoCodeTest {

    @Test
    public void test1() throws Exception {
        GeoCodeTest geoCodeTest = new GeoCodeTest();
//        GoogleGeoResult googleGeoResult = geoCodeTest.getGeoCode("226016", false).getResults()[0];
//        Assert.assertEquals("26.8915707", googleGeoResult.getGeometry().getLocation().getLat());
//        Assert.assertEquals("80.9926327", googleGeoResult.getGeometry().getLocation().getLng());
    }

    @Test
    public void test2() throws Exception {
        GeoCodeTest geoCodeTest = new GeoCodeTest();
//        GoogleGeoResult googleGeoResult = geoCodeTest.getGeoCode("", false).getResults()[0];
//        Assert.assertEquals("26.8915707", googleGeoResult.getGeometry().getLocation().getLat());
//        Assert.assertEquals("80.9926327", googleGeoResult.getGeometry().getLocation().getLng());
    }
}
