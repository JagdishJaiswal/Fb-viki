package com.POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	public static WebDriver driver;

	@FindBy(tagName = "h2")
	private WebElement text;
	@FindBy(id = "email")
	private WebElement userName;
	@FindBy(id = "pass")
	private WebElement password;
	@FindBy(name = "login")
	private WebElement login_btn;
	@FindBy(xpath = "//a[text()='Create New Account']")
	private WebElement create_Acc;
	@FindBy(name = "firstname")
	private WebElement firstname;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement mobile;
	@FindBy(xpath = "//input[@data-type='password']")
	private WebElement crt_password;
	@FindBy(id = "day")
	private WebElement day;
	@FindBy(id = "month")
	private WebElement month;
	@FindBy(id = "year")
	private WebElement year;
	@FindBy(xpath = "//label[text()='Male']")
	private WebElement gender;
	@FindBy(name = "websubmit")
	private WebElement submit;

	public Login_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getText() {
		return text;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	public WebElement getCreate_Acc() {
		return create_Acc;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getCrt_password() {
		return crt_password;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getSubmit() {
		return submit;
	}

}
