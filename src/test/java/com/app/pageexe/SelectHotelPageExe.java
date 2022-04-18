package com.app.pageexe;

import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.locators.SearchPageLocators;
import com.app.locators.SelectHotelPageLocators;

public class SelectHotelPageExe extends SelectHotelPageLocators{
	
	public static void selectCheckBox() {
		BaseClass.click(BaseClass.findElementById(SelectHotelPageLocators.checkBoxId));
	}

	public static void continueButton() {
		BaseClass.click(BaseClass.findElementById(SelectHotelPageLocators.continueId));
	}
}
