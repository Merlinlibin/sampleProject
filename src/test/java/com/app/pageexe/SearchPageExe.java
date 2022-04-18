package com.app.pageexe;

import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.locators.SearchPageLocators;

public class SearchPageExe  extends SearchPageLocators{
	  
	public static void location() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.locationId), "London");
	}
     
	public static void hotel() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.hotelId), "Hotel Sunshine");
	}
     
	public static void roomType() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.roomTypeId), "Standard");
	}
     
	public static void noOfRooms() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.noOfRoomsId), "2");
	}
     
	public static void checkIn() {
		BaseClass.sendData(BaseClass.findElementById(SearchPageLocators.checkInId), BaseClass.dataFromexcel(2, 1));
	}
     
	public static void CheckOut() {
		BaseClass.sendData(BaseClass.findElementById(SearchPageLocators.checkOutId), BaseClass.dataFromexcel(3, 1));
	}
     
	public static void adultPerRoom() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.adultPerRoomId), "2");
	}
     
	public static void childPerRoom() {
		BaseClass.dropDownvalue(BaseClass.findElementById(SearchPageLocators.childPerRoomId), "1");
	}
    
	public static void searchButton() {
		BaseClass.click(BaseClass.findElementById(SearchPageLocators.searchId));
	}

}
