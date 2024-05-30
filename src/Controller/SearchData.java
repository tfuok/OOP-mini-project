/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HotelDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SearchData {
    
    public HotelDTO searchHotelByID(ArrayList<HotelDTO> arr, String id) {
        for (HotelDTO hotelDTO : arr) {
            if (hotelDTO.getId().equalsIgnoreCase(id)) {
                return hotelDTO;
            }
        }
        return null;
    }
    
    public List<HotelDTO> searchHotelByName(ArrayList<HotelDTO> arr, String name) {
        ArrayList<HotelDTO> temp = new ArrayList<>();
        for (HotelDTO hotelDTO : arr) {
            if (hotelDTO.getName().toLowerCase().contains(name)) {
                temp.add(hotelDTO);
            }
        }
        return temp;
    }
}
