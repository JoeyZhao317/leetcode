package com.buptcoder.acm;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicateTest {

    @Before
    public void setUp() {
        System.out.println("Start test");
    }

    @Test
    public void test() {
        RemoveDuplicate remove = new RemoveDuplicate();
        int[] test1 = {1,1,2};
        int[] test2 = {1,2,3,4,4,6,6};
        assertEquals(2, remove.removeDuplicates(test1));
        assertEquals(5, remove.removeDuplicates(test2));
    }
}
