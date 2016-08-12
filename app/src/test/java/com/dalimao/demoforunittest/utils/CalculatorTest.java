package com.dalimao.demoforunittest.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liuguangli on 16/8/12.
 */
public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void setUp() throws Exception {

        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(2, calculator.add(1 , 1));
    }
}