/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukol1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 2016-e-bakhtina
 */
public class MyHistoryTest {
    private MyHistory h;
    private Path p;
    
    @Before
    public void prepare() throws IOException {
        p = Files.createTempFile("myTest", null);
        h = new MyHistory(p.toString());
    }
    
    @Test
    public void initTest() {
        h = new MyHistory("z:test.txt");
        h.addLine("ahoj");
        h.addLine("ahoj");

        assertEquals("ahoj", h.toString());
    }

    @Test
    public void readTest1() throws IOException {
        // init
        ArrayList<String> arr = new ArrayList();
        arr.add("ahoj");
        arr.add("nazdar");
        Files.write(p, arr);

        // test
        h = new MyHistory(p.toString());
        h.read();
        assertEquals("ahoj\nnazdar", h.toString());
    }
    
    @Test(expected = IOException.class)
    public void saveTest() throws IOException {
        
        h = new MyHistory(p.toString());
        h.save();
        assertEquals("", h.toString());
    }
    
   
    
    @Test
    public void write0 () throws IOException {       
        try {
            h.save();
        } catch (Exception e){}  
    }
    
    @Test
    public void write1 () throws IOException {
        try {
            h.addLine("cus");
            h.save();
        } catch (Exception e){}    
    }
    
    @Test
    public void write2 () throws IOException {
        try {
            h.addLine("cus2");
            h.save();
        } catch (Exception e){}
        
    }
    
    @After
    public void after() {
        p.toFile().deleteOnExit();
    }
}

//nebude vraxcet duplicitni radky
//kdy vytvori soubor kde bude ahoj 2x, dostanu ahoj jen jednou