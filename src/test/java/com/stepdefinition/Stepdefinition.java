package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.POM.page.Login_Page;
import com.Property_FIle.ConfigurationHelper;
import com.mav.practice.Advance_code.XLSX_Reader;
import com.mav.practice.Advance_code.XLSX_Writer;
import com.runner.RunnerClassFacebook;
import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BaseClass {

	public static WebDriver driver = RunnerClassFacebook.driver;
	public static String moblile;
	public static String crt_pass1;
	public static Login_Page l = new Login_Page(driver);

	@Given("user Launch The Url")
	public void user_launch_the_url() throws IOException {
		launchUrl(ConfigurationHelper.getInstance().getUrl());
	}

	@When("get The Text From HomePage")
	public void get_the_text_from_home_page() throws IOException {
		XLSX_Writer.writeData("facebook", 0, 0, l.getText().getText());
	}

	@When("user Enter The Username")
	public void user_enter_the_username() throws IOException {

		userInput(l.getUserName(), ConfigurationHelper.getInstance().getUsername());
//		XLSX_Reader.particlarData("facebook", 2, 0)
	}

	@When("enter The Password")
	public void enter_the_password() throws IOException {

		userInput(l.getPassword(), ConfigurationHelper.getInstance().getPassword());
//		XLSX_Reader.particlarData("facebook", 2, 1)
	}

	@When("click The Login button")
	public void click_the_login_button() throws InterruptedException {
		clickonElement(l.getLogin_btn());
		sleep(5000);
	}

	@Then("validate With Screenshot and Back To Home Page")
	public void validate_with_screenshot_and_back_to_home_page() throws IOException {
		screenShot("login_acc");
		navigateBack();
	}

	@When("user Click The Create Account Button")
	public void user_click_the_create_account_button() throws InterruptedException {
		clickonElement(l.getCreate_Acc());
		sleep(5000);
	}

	@When("enter The Firstname and Lastname")
	public void enter_the_firstname_and_lastname() throws IOException {

		userInput(l.getFirstname(), XLSX_Reader.particlarData("facebook", 2, 0));
		userInput(l.getLastname(), XLSX_Reader.particlarData("facebook", 2, 1));
	}

	@When("enter The Mobile Number and Type Password")
	public void enter_the_mobile_number_and_type_password() throws IOException {
		userInput(l.getMobile(), XLSX_Reader.particlarData("facebook", 2, 2));
		userInput(l.getCrt_password(), XLSX_Reader.particlarData("facebook", 2, 3));
	}

	@When("select The Date Of Birth and Gender")
	public void select_the_date_of_birth_and_gender() {
		selectMethods(l.getDay(), "value", "4");

		selectMethods(l.getMonth(), "text", "Mar");

		selectMethods(l.getYear(), "value", "1993");

		clickonElement(l.getGender());

	}

	@Then("click Submit and TakeScreenShot")
	public void click_submit_and_take_screen_shot() throws IOException, InterruptedException {
		clickonElement(l.getSubmit());

		Thread.sleep(7000);
		screenShot("create_acc");
	}

}
