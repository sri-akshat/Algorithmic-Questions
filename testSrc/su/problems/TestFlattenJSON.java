package su.problems;

import org.junit.Assert;

import java.io.IOException;

/**
 * Created by Akshat on 2/1/2015.
 */
public class TestFlattenJSON {

    @org.junit.Test
    public void testCompute() throws IOException {

        String str = "{\"Order\" : {\"id\" : \"1\",\"name\" : \"order1\",\"OrderItems\" : \"A\"},\"A\" : {\"pId\" : \"1\",\"pName\" : \"mobile\",\"pDetail\" : \"B\"},\"B\" : {\"pDesc\" : \"mobile device\"}}";
        FlattenJSON flattenJSON = new FlattenJSON();
        Assert.assertEquals("{\"Order\" : {\"id\" : \"1\",\"name\" : \"order1\",\"OrderItems\" : {\"pId\" : \"1\",\"pName\" : \"mobile\",\"pDetail\" : {\"pDesc\" : \"mobile device\"}}}}",flattenJSON.compute(str));
    }

    @org.junit.Test
    public void testComputeWithNullInput() throws IOException {

        String str = null;
        FlattenJSON flattenJSON = new FlattenJSON();
        Assert.assertEquals("{\"Order\" : {\"id\" : \"1\",\"name\" : \"order1\",\"OrderItems\" : {\"pId\" : \"1\",\"pName\" : \"mobile\",\"pDetail\" : {\"pDesc\" : \"mobile device\"}}}}",flattenJSON.compute(str));
    }


}
