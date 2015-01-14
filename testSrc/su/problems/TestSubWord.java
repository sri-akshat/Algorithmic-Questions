package su.problems;

import org.junit.*;
import org.junit.Test;

/**
 * Created by Akshat on 1/9/2015.
 */
public class TestSubWord {

    @Test
    public void testFindSubWords(){

        SubWord subWord = new SubWord();
        Assert.assertEquals(4,subWord.findSubWords("HoneyPot").size());
    }
}
