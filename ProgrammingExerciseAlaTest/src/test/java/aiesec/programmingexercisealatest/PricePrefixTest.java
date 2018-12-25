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

/**
 *
 * @author ameni
 */
public class PricePrefixTest {
    
    public PricePrefixTest() {
    }
    
   @Test
   public void compare(){
   PricePrefix p=new PricePrefix("144",1.0);
   PricePrefix p1=new PricePrefix("1445",1.5);
   PricePrefix p2=new PricePrefix("14",1.0);
       
       assertFalse(p1.lessThan(p1));
       assertFalse(p.lessThan(p2));
   }
    
}
