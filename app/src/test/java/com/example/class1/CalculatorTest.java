package com.example.class1;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator cal;
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        cal = new Calculator(); //initzn
    }
    public void testAdd()
    {
        int expected=20;
        int actual=cal.add(15,5);
        assertEquals(expected,actual);
    }

    public void testMul()
    {
        int expected=30;
        int actual=cal.mul(6,5);
        assertEquals(expected,actual);
    }

    public void testDiv()
    {
        int expected=2;
        int actual=cal.mul(6,3);
        assertEquals(expected,actual);
    }
}