package com.stepdefinition;

import java.util.List;
import java.util.Map;

import com.app.pageexe.BookingPageExe;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BookingPageExe {
	@Given("Login into the Application")
	public void login_into_the_application() {
	    browserLaunch();
		System.out.println("launch");
	}
	@When("Enter the user name {string}")
	public void enter_the_user_name(String name) {
	   username(name);
	}
	@When("Enter the password {string}")
	public void enter_the_password(String pass) {
	  password(pass);
	}
	@When("Click the login")
	public void click_the_login() {
      loginButton();
	}
	@Then("Validate the Home page title")
	public void validate_the_home_page_title() {


	}
	@When("Enter the invalid user name {string}")
	public void enter_the_invalid_user_name(String name) {
	   username(name);
	}
	@When("Enter the invalid user name <name>")
	public void enter_the_invalid_user_name_name(DataTable aslist) {
		List<String> asList2 = aslist.asList();
	   username(asList2.get(0));
		System.out.println(asList2.get(0));
	}

	@When("Enter the password <pass>")
	public void enter_the_password_pass(DataTable aslist) {
		List<String> asList2 = aslist.asList();
	    password(asList2.get(3));
		System.out.println(asList2.get(3));
	}

	@When("Enter the password")
	public void enter_the_password(io.cucumber.datatable.DataTable dataTable) {
		List<String> asList2 = dataTable.asList();
		username(asList2.get(0));
	    password(asList2.get(3));
		System.out.println(asList2.get(3));
	}
//	@Given("Enter the username & password")
//	public void enter_the_username_password(io.cucumber.datatable.DataTable dataTable) {
//	   List<List<String>> asLists = dataTable.asLists();
//	   username(asLists.get(0).get(0));
//	    password(asLists.get(0).get(1)); 
//	}
	

	@When("Enter the username & password")
	public void enter_the_username_password(io.cucumber.datatable.DataTable dataTable) {
//		 Map<String, String> asMap = dataTable.asMap(String.class, String.class);
//		   username(asMap.get("1"));
//	    password(asMap.get("2")); 
		List<Map<String, String>> asMaps = dataTable.asMaps();
		username(asMaps.get(0).get("name1"));
		password(asMaps.get(1).get("name1"));
	
	}
}
