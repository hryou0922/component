package com.hry.guava.collect;

import com.hry.guava.collection.MultiCollectionDemo;
import org.junit.Test;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/16 9:53
 */
public class MultiMapDemoTest {

    @Test
    public void testMultimap(){
        MultiCollectionDemo multiMapDemo = new MultiCollectionDemo();
        multiMapDemo.testMultimap();
    }


    @Test
    public void testMultset(){
        MultiCollectionDemo multiMapDemo = new MultiCollectionDemo();
        multiMapDemo.testMultset();
    }

    @Test
    public void testTable(){
        MultiCollectionDemo multiMapDemo = new MultiCollectionDemo();
        multiMapDemo.testTable();
    }

    @Test
    public void testRangeSet(){
        MultiCollectionDemo multiMapDemo = new MultiCollectionDemo();
        multiMapDemo.testRangeSet();
    }
}
