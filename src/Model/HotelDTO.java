/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class HotelDTO implements Serializable {

    private String id, name, address, phone;
    private int available, rating;
    private double price;

    public HotelDTO() {
    }

    public HotelDTO(String id, String name, String address, String phone, int available, int rating, double price) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.available = available;
        this.rating = rating;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("|%-5s | %-10s | %-15d | %-55s | %-10s | %-5s |%-10s |\n",
                id, name, available, address, phone, rating +" Star", price);
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------|");

        return "";
    }

}
