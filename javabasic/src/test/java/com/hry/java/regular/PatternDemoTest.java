package com.hry.java.regular;

import org.junit.Assert;
import org.junit.Test;

public class PatternDemoTest {

    @Test
    public void testPhone(){
        PatternDemo patternDemo = new PatternDemo();
        Assert.assertEquals(true, patternDemo.isFixedPhone("057188856923"));
        Assert.assertEquals(true, patternDemo.isFixedPhone("052188856923"));
        Assert.assertEquals(true, patternDemo.isFixedPhone("13989467221"));
        Assert.assertEquals(false, patternDemo.isFixedPhone("abc"));
    }
}
