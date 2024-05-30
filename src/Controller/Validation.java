/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HotelDTO;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validation {

    private final Scanner sc;
    private final SearchData sd;

    public Validation() {
        sc = new Scanner(System.in);
        sd = new SearchData();
    }

    public String checkID(ArrayList<HotelDTO> arr) {
        String id;
        System.out.println("Enter Hotel id: ");
        do {
            id = sc.nextLine();
            if (sd.searchHotelByID(arr, id) != null) {
                System.err.println("Duplicated code.Try with another one");
            } else if (id.trim().isEmpty()) {
                System.err.println("ID can't not empty!");
            } else {
                return id.toUpperCase();
            }
        } while (true);
    }

    public int checkInteger(String msg, int x, int y) {
        System.out.println(msg);
        boolean check = true;
        int input;
        while (check) {
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < x || input > y) {
                    System.out.println("This number must be " + x + " to " + y);
                    check = true;
                } else {
                    return input;
                }

            } catch (NumberFormatException e) {
                System.err.println("This must be number");
                check = true;
            }
        }
        return 0;
    }

    public double checkDouble(String msg, int x, int y) {
        System.out.println(msg);
        boolean check = true;
        double input;
        while (check) {
            try {
                input = Double.parseDouble(sc.nextLine());
                if (input < x || input > y) {
                    System.out.println("This number must be " + x + "to" + y);
                    check = true;
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.err.println("This must be number");
                check = true;
            }
        }
        return 0;
    }

    public String checkPhone(String alert) {
        String s;
        while (true) {
            try {
                System.out.println(alert);
                s = sc.nextLine();
                if (!s.isEmpty() && s.matches("0\\d{9}")) {
                    return s;

                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public String inputStringNotEmpty(String msg) {
        String input = "";
        do {
            System.out.println(msg);
            input = sc.nextLine();
        } while (input.trim().isEmpty());
        return input;
    }

    public boolean inputYN(String msg) {
        String choice;
        while (true) {
            System.out.println(msg);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must be Y or N");
            }
        }
    }

//***************UPDATE INPUT
    public String inputNameUD(String msg, HotelDTO hotel) {
        String name = "";
        System.out.println(msg);
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        do {
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                return hotel.getName();
            } else if (!pattern.matcher(name).matches()) {
                System.out.println("Please enter the correct format of the name");
            } else {
                return name;
            }
        } while (true);
    }

    public int inputHotelAvailableUD(String msg, HotelDTO hotel) {
        System.out.println(msg);
        boolean check = true;
        int input;
        try {
            while (check) {
                String string = sc.nextLine();
                if (string.trim().isEmpty()) {
                    input = hotel.getAvailable();
                    return input;
                } else {
                    input = Integer.parseInt(string);
                    return input;
                }

            }
        } catch (NumberFormatException e) {
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }

    public String inputAddressUD(String msg, HotelDTO hotel) {
        String name = "";
        System.out.println(msg);
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
        do {
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                return hotel.getAddress();
            } else if (!pattern.matcher(name).matches()) {
                System.out.println("Please enter the correct format of the address");
            } else {
                return name;
            }
        } while (true);
    }

    public String inputPhoneUD(String msg, HotelDTO hotel) {
        String phone = "";
        System.out.println(msg);
        Pattern pattern = Pattern.compile("0\\d{9}");
        do {
            phone = sc.nextLine();
            if (phone.trim().isEmpty()) {
                return hotel.getPhone();
            } else if (!pattern.matcher(phone).matches()) {
                System.out.println("Please enter the correct format of the phone");
            } else {
                return phone;
            }
        } while (true);
    }

    public int inputHotelRatingUD(String msg, HotelDTO hotel) {
        System.out.println(msg);
        boolean check = true;
        int input;
        try {
            while (check) {
                String string = sc.nextLine();
                if (string.trim().isEmpty()) {
                    input = hotel.getRating();
                    return input;
                } else {
                    input = Integer.parseInt(string);
                    return input;
                }

            }
        } catch (NumberFormatException e) {
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }

    public double inputPriceUD(String msg, int x, int y, HotelDTO hotel) {
        System.out.println(msg);
        boolean check = true;
        double input;
        try {
            while (check) {
                String string = sc.nextLine();
                if (string.trim().isEmpty()) {
                    input = hotel.getPrice();
                    return input;
                } else {
                    input = Double.parseDouble(string);
                    return input;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("This must be number");
            check = true;
        }
        return 0;
    }
}
