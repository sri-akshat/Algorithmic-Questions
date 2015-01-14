package su;

import junit.framework.Assert;
import org.junit.Test;
import su.dataStructure.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 1/27/13
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStack {

    @Test
    public void testPushPop(){
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertEquals("Last element not getting popped..:/", stack.pop(), 5);
        Assert.assertEquals("Last element not getting popped..:/", stack.pop(), 4);
        Assert.assertEquals("Last element not getting popped..:/", stack.pop(), 3);
        Assert.assertEquals("Last element not getting popped..:/", stack.pop(), 2);
        Assert.assertEquals("Last element not getting popped..:/", stack.pop(), 1);
    }

    @Test (expected = RuntimeException.class)
    public void testPopEdgeCase(){
        Stack stack = new Stack(0);
        stack.pop();
    }

    @Test (expected = RuntimeException.class)
    public void testPushEdgeCase(){
        Stack stack = new Stack(1);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void testIsEmpty(){
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        Assert.assertEquals("isEmpty should be false", stack.isEmpty(), false);
        stack.pop();
        stack.pop();
        Assert.assertEquals("isEmpty should be true", stack.isEmpty(), true);
    }
}
