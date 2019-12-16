/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukol1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2016-e-bakhtina
 */
public class MyHistory {
    private Path filePath;
    private List<String> myList;
    
    public MyHistory(String fileName) {
        filePath = Paths.get(fileName);
    }

    public void read() throws IOException {
        myList = Files.readAllLines(filePath);
    }

    public void save() throws IOException {
        Files.write(filePath, myList);
    }

    public void addLine(String str) {
        if(myList == null) {
            myList = new ArrayList();
        }
        if(!myList.contains(str)){
            myList.add(str);
        }
    }
    
    public String toString() {
        return String.join("\n", myList);
    }
}