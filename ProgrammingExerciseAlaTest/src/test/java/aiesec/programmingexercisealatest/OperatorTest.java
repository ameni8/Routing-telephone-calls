/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiesec.programmingexercisealatest;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ameni
 */
public class OperatorTest {

    private static Operator operator;

    public OperatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        operator = Operator.OperatorBuilder.operator("Operator A")
                .add(new PricePrefix("1", 0.9))
                .add(new PricePrefix("268", 5.1))
                .add(new PricePrefix("46", 0.17))
                .add(new PricePrefix("4620", 0.0))
                .add(new PricePrefix("468", 0.15))
                .add(new PricePrefix("4631", 0.15))
                .add(new PricePrefix("4673", 0.9))
                .add(new PricePrefix("46732", 1.1))
                .build();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPrefix() {
        PricePrefix pricePrefix = operator.getCheapestPrice("2273212345");
        assertNull("No prefix", pricePrefix);
        pricePrefix = operator.getCheapestPrice("4673212345");
        assertEquals("prefix", "46732", pricePrefix.getPrefix());
        assertEquals("price", Double.valueOf(1.1), pricePrefix.getPrice());
         pricePrefix = operator.getCheapestPrice("4655212345");
        assertEquals("prefix", "46", pricePrefix.getPrefix());
        assertEquals("price", Double.valueOf(0.17), pricePrefix.getPrice());
    }

    @Test
    public void PricePrefixListIsSorted() {
        PricePrefix previous;
        PricePrefix current;
        for (int i = 1; i < operator.getPricePrefixList().size(); i++) {
            previous = operator.getElement(i - 1);
            current = operator.getElement(i);
            assertTrue("Not sorted", current.getPrefix().length() <= previous.getPrefix().length());

        }
        
    }
    @Test(expected=RuntimeException.class)
    public  void except(){
    Operator.OperatorBuilder.operator("incorrect operator").build();
    }

}
