/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Function;
import Controller.Validation;
import Model.HotelDAO;
import Model.HotelDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        final String FName = "hotel.dat";
        ArrayList<HotelDTO> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Function hotel = new Function(arr);
        Validation val = new Validation();
        HotelDAO dao = new HotelDAO();
        dao.loadDataFromFile(arr, FName);
        do {
            System.out.println("---------------------------");
            System.out.println("1: Adding new Hotel.");
            System.out.println("2: Checking exists Hotel.");
            System.out.println("3: Updating Hotel information.");
            System.out.println("4: Deleting Hotel. ");
            System.out.println("5: Searching Hotel.");
            System.out.println("6: Displaying a hotel list (descending by Hotel_Name).");
            System.out.println("7: Exit the program.");
            choice = val.checkInteger("Enter 1 to 7: ", 1, 8);

            switch (choice) {
                case 1:
                    hotel.add();
                    dao.saveDataToFile(arr, FName);
                    break;
                case 2:
                    hotel.checkExist();
                    break;
                case 3:
                    hotel.update();
                    dao.saveDataToFile(arr, FName);
                    break;
                case 4:
                    hotel.delete();
                    dao.saveDataToFile(arr, FName);
                    break;
                case 5:
                    hotel.search();
                    break;
                case 6:
                    hotel.display();
                    break;
            }

        } while (choice != 7);

        sc.close();
    }
}
