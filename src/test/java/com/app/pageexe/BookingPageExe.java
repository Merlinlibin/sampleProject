package com.app.pageexe;

import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.locators.BookingPageLocators;

public class BookingPageExe extends BookingPageLocators{
	   
	public static void firstName() {
		BaseClass.sendData(BaseClass.findElementById(BookingPageLocators.fNameId), BaseClass.dataFromexcel(4, 1));
	}
	   
	public static void lastName() {
		BaseClass.sendData(BaseClass.findElementById(BookingPageLocators.lNameId), BaseClass.dataFromexcel(5, 1));
	}
	   
	public static void address() {
		BaseClass.sendData(BaseClass.findElementById(BookingPageLocators.addressId), BaseClass.dataFromexcel(6, 1));
	}
	   
	public static void cardNumber() {
		BaseClass.sendData(BaseClass.findElementById(BookingPageLocators.cardNoId), BaseClass.dataFromexcel(7, 1));
	}
	   
	public static void cardType() {
		BaseClass.dropDownvalue(BaseClass.findElementById(BookingPageLocators.cardTypeId), "AMEX");
	}

	   
	public static void cardExpMonth() {
		BaseClass.dropDownvalue(BaseClass.findElementById(BookingPageLocators.cardExpMonthId), "12");
	}
	   

	public static void cardExpYear() {
		BaseClass.dropDownvalue(BaseClass.findElementById(BookingPageLocators.cardExpYearId), "2022");
	}
	   

	public static void cvv() {
		BaseClass.sendData(BaseClass.findElementById(BookingPageLocators.ccvId), BaseClass.dataFromexcel(8, 1));
	}
	   
	public static void bookNow() {
		BaseClass.click(BaseClass.findElementById(BookingPageLocators.bookNowId));
	}
	   
	public static void orderId() {
		BaseClass.pageEnd(BaseClass.findElementById(BookingPageLocators.orderNoId));
		BaseClass.jsGetAttribute(BaseClass.findElementById(BookingPageLocators.orderNoId));
	}
}
