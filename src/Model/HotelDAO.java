/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HotelDAO {

    public <T> boolean saveDataToFile(List<T> list, String FName) {
        try {
//generic = object tính toàn vẹn dữ liệu
            File f = new File(FName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            for (T item : list) {
                o.writeObject(item);
            }
            fos.close();
            o.close();
            return true; // Indicates a successful save
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
   //ghi file dưới dạng object, những file trong này sẽ lưu object và đc chuyển đỏi sang text nhờ serializable tron entity
    public <T> boolean loadDataFromFile(List<T> list, String FName) {
        try {
            File f = new File(FName);
            if (!f.exists()) {
                return false;
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fis);
            if (f.length() == 0) {
                System.err.println("File is empty");
            }
            boolean check = true;
            while (check) {
                try {
                    T c = (T) oi.readObject();
                    list.add(c);
                } catch (EOFException e) {
                    break;
                }
            }
            fis.close();
            oi.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + FName + e);
            return false;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing double value from input: " + e.getMessage());
            return false;
        }
        return true;
    }
}
