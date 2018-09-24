/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asis3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import asis3.student;

/**
 *
 * @author biobii
 */
public class demo {
    
    public void serialize(List<student> pList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(pList);
        } catch (IOException ex) {
            System.out.println("a problem occured during serialization.\n" + ex.getMessage());
        }
    }
    
    public List<student> deserialize(String fileName) {
        List<student> pList = null;
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            pList = (List<student>) in.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("masalah terjadi %s%n" + fileName);
            System.out.println(e.getMessage());
        }
        
        return pList;
    }
    
}
