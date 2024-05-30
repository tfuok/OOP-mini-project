/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HotelDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import Model.HotelDAO;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Function implements IFunction {

    private ArrayList<HotelDTO> arr = new ArrayList<>();
    private final Validation dv;
    private final SearchData sd;
    private final Scanner sc;

    public Function(ArrayList<HotelDTO> hotel) {
        arr = hotel;
        dv = new Validation();
        sd = new SearchData();
        sc = new Scanner(System.in);
    }

    public ArrayList<HotelDTO> getArr() {
        return arr;
    }

    public void setArr(ArrayList<HotelDTO> arr) {
        this.arr = arr;
    }

    @Override
    public void add() {
        boolean choice = true;
        while (choice) {
            String id = dv.checkID(arr);
            String name = dv.inputStringNotEmpty("Enter hotel name:");
            String address = dv.inputStringNotEmpty("input hotel's address: ");
            int room = dv.checkInteger("input hotel's available room: ", 0, Integer.MAX_VALUE);
            String phone = dv.checkPhone("input hotel's phone: ");
            int rate = dv.checkInteger("input hotel rating", 0, 5);
            double price = dv.checkDouble("Input price", 0, Integer.MAX_VALUE);

            arr.add(new HotelDTO(id, name, address, phone, room, rate, price));

            System.out.println("Add Successfully!");
            choice = dv.inputYN("Do you want to continue?(Y/N): ");
        }
    }

    @Override
    public void checkExist() {
        System.out.println("Enter hotel ID:");
        String id = sc.nextLine();
        HotelDAO dao = new HotelDAO();
        HotelDTO ll = sd.searchHotelByID(arr, id);
        if (ll != null) {
            System.out.println("Exist Hotel! ");
            System.out.println(ll);
        } else {
            System.out.println("No Hotel Found!");
        }

    }

    @Override
    public void update() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        HotelDTO item = sd.searchHotelByID(arr, id);
        HotelDAO dao = new HotelDAO();
        if (item != null) {
            System.out.println("Here is the hotel information:");
            System.out.println(item);
            String curid = item.getId();
            String updatedName = dv.inputNameUD("Enter name you want to update: ",item);
            int updatedRoomAvailable = dv.inputHotelAvailableUD("Enter new Hotel Room Available: ", item);
            String updatedAddress = dv.inputAddressUD("Enter new Hotel Address: ", item);
            String updatedPhone = dv.inputPhoneUD("Enter new Hotel Phone (0xxxxxxxxx): ", item);
            int updatedRating = dv.inputHotelRatingUD("Enter new Hotel Rating (0-5) star: ", item);
            Double updatePrice = dv.inputPriceUD("Enter new Price", 0, Integer.MAX_VALUE, item);

            HotelDTO updatedHotel = new HotelDTO(
                    curid,
                    updatedName,
                    updatedAddress,
                    updatedPhone,
                    updatedRoomAvailable,
                    updatedRating,
                    updatePrice);

            int pos = arr.indexOf(item);
            arr.set(pos, updatedHotel);

            System.out.println("Update successfully!!");
            System.out.println("Updated Hotel Information:");
            System.out.println(updatedHotel);
        } else {
            System.out.println("Hotel not found!");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        HotelDTO item = sd.searchHotelByID(arr, id);
        boolean choice = true;
        if (item != null) {
            System.out.println("Found! Here is your hotel:");
            System.out.println(item);
            choice = dv.inputYN("You really want to delete(Y/N): ");
            if (choice) {
                arr.remove(item);
                System.out.println("Delete Successfully!");
            }
        } else {
            System.out.println("Not found!");
        }
    }

    @Override
    public void search() {
        System.out.println("What do you want to search?:");
        System.out.println("1. Search by NAME");
        System.out.println("2. Search by ID");
        int choice = dv.checkInteger("Enter your choice: ", 1, 2);
        switch (choice) {
            case 1:
                System.out.println("Enter name:");
                String name = sc.nextLine();
                List<HotelDTO> nn = sd.searchHotelByName(arr, name);
                if (nn != null) {
                    System.out.println("Here is your hotel: ");
                    System.out.println(nn);
                } else {
                    System.out.println("Not found");
                }
                break;
            case 2:
                System.out.println("Enter ID you want to search:");
                String id = sc.nextLine();
                HotelDTO ss = sd.searchHotelByID(arr, id);
                if (ss != null) {
                    System.out.println("Here is your hotel: ");
                    System.out.println(ss);
                } else {
                    System.out.println("Not found");
                }
                break;
        }
    }

    @Override
    public void display() {
        System.out.printf("|%-5s | %-10s | %-15s | %-55s | %-10s | %-5s| %-10s |\n",
                "ID", "Name", "Available Rooms", "Address", "Phone", "Rating", "Price");
        Collections.sort(arr, nameComparator);
        for (HotelDTO hotel : arr) {
            System.out.println(hotel);
        }
    }

    public static Comparator nameComparator = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            HotelDTO v1 = (HotelDTO) o1;
            HotelDTO v2 = (HotelDTO) o2;
            return v2.getName().compareToIgnoreCase(v1.getName());
        }
    };

}
