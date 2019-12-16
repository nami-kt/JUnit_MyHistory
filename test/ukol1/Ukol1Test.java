/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukol1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2016-e-bakhtina
 */
public class Ukol1Test {
    
    public Ukol1Test() {
    }

    @Test
    public void testPositive() {
        int out = Ukol1.min(1, 2);
        assertEquals(1, out);
    }

    @Test
    public void testNegative() {
        int out = Ukol1.min(-1, -2);
        assertEquals(-2, out);
    }
    
}
