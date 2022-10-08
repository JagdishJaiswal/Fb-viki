package com.mav.practice.maven_project;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mav.practice.Advance_code.XLSX_Reader;
import com.mav.practice.Advance_code.XLSX_Writer;

import baseClass.BaseClass;

public class Facebook extends BaseClass {

	public static WebDriver driver;
	public static String user;
	public static String pass;
	public static String firstname;
	public static String lastname;
	public static String moblile;
	public static String crt_pass1;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		WebElement text = driver.findElement(By.tagName("h2"));
		String t = text.getText();
		XLSX_Writer.writeData("facebook", 0, 0, t);
		user = XLSX_Reader.particlarData("facebook", 2, 0);
		WebElement email = driver.findElement(By.id("email"));
		userInput(email, user);
		pass = XLSX_Reader.particlarData("facebook", 2, 1);
		WebElement password = driver.findElement(By.id("pass"));
		userInput(password, pass);

		WebElement login = driver.findElement(By.name("login"));
		clickonElement(login);
		Thread.sleep(3000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\VIGNESH S\\eclipse-workspace\\FACEBOOK_PROJECT\\Screenshot\\login_acc.png");
		FileUtils.copyFile(source, destination);

		driver.navigate().back();

		WebElement crt_acc = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		clickonElement(crt_acc);

		Thread.sleep(2000);
		firstname = XLSX_Reader.particlarData("facebook", 2, 2);
		WebElement first_name = driver.findElement(By.name("firstname"));
		userInput(first_name, firstname);
		lastname = XLSX_Reader.particlarData("facebook", 2, 3);
		WebElement last_name = driver.findElement(By.name("lastname"));
		userInput(last_name, lastname);
		moblile = XLSX_Reader.particlarData("facebook", 2, 4);
		WebElement mobile = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
		userInput(mobile, moblile);
		crt_pass1 = XLSX_Reader.particlarData("facebook", 2, 3);
		WebElement crt_pass = driver.findElement(By.xpath("//input[@data-type='password']"));
		userInput(crt_pass, crt_pass1);

		WebElement day = driver.findElement(By.id("day"));
		Select s = new Select(day);
		s.selectByValue("4");

		WebElement month = driver.findElement(By.id("month"));
		Select s1 = new Select(month);
		s1.selectByVisibleText("Mar");

		WebElement year = driver.findElement(By.id("year"));
		Select s2 = new Select(year);
		s2.selectByValue("1993");

		WebElement male = driver.findElement(By.xpath("//label[text()='Male']"));
		clickonElement(male);

		WebElement crtacc_submit = driver.findElement(By.name("websubmit"));
		clickonElement(crtacc_submit);

		Thread.sleep(7000);

		File source1 = ts.getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Users\\VIGNESH S\\eclipse-workspace\\FACEBOOK_PROJECT\\Screenshot\\create_acc.png");
		FileUtils.copyFile(source1, destination1);
	}
}
