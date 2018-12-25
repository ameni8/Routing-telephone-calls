/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiesec.programmingexercisealatest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import aiesec.programmingexercisealatest.Router.Process;

/**
 *
 * @author ameni
 */
public class RouterTest {

    private static Operator operatorA;
    private static Operator operatorB;

    public RouterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        operatorA = Operator.OperatorBuilder.operator("Operator A")
                .add(new PricePrefix("1", 0.9))
                .add(new PricePrefix("268", 5.1))
                .add(new PricePrefix("46", 0.17))
                .add(new PricePrefix("4620", 0.0))
                .add(new PricePrefix("468", 0.15))
                .add(new PricePrefix("4631", 0.15))
                .add(new PricePrefix("4673", 0.9))
                .add(new PricePrefix("46732", 1.1))
                .build();
        operatorB = Operator.OperatorBuilder.operator("Operator B")
                .add(new PricePrefix("1", 0.8))
                .add(new PricePrefix("44", 0.5))
                .add(new PricePrefix("46", 0.2))
                .add(new PricePrefix("467", 1.0))
                .add(new PricePrefix("48", 1.2))
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
    public void cheapestprice(){
        Process process = Router.router(operatorA,operatorB).dial("4613212345");
        assertEquals(Double.valueOf(0.17), process.getCheapestPrice());
        assertEquals("46", process.getCheapestPrefix());
        assertEquals("Operator A", process.getOperatorName());
        // process = Router.router(operatorA,operatorB).dial("4444444444");
        //assertEquals(Double.valueOf(0.5), process.getCheapestPrice());
        //assertEquals("44", process.getCheapestPrefix());
        //assertEquals("Operator B", process.getOperatorName());
        
    }

}
