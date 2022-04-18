package com.app.pageexe;

import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.locators.LoginPageLocators;

public class LoginPageExe extends LoginPageLocators {
	
     
	public static void username(String name) {
		BaseClass.sendData(BaseClass.findElementById(LoginPageLocators.usernameId), name);
	}
	
     
	public static void password(String pass) {
		BaseClass.sendData(BaseClass.findElementById(LoginPageLocators.passwordId), pass);
	}
     
	public static void loginButton() {
		BaseClass.click(BaseClass.findElementByxpath(LoginPageLocators.loginButtonXpath));
	}

}
