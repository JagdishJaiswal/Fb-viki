package baseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickonElement(WebElement element) {
		element.click();
	}

	public static void clearonElement(WebElement element) {
		element.clear();
	}

	public static void getTextOnElement(WebElement element) {
		String text = element.getText();
		System.out.println("The Element Text is : " + text);
	}

	public static void getAttributeOnElement(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println("The Element attribute is : " + attribute);
	}

	public static void isDisplayedOnElement(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("If The Element is Displayed : " + displayed);
	}

	public static void isEnabledOnElement(WebElement element) {
		boolean enable = element.isEnabled();
		System.out.println("If The Element is Enabled : " + enable);
	}

	public static void isSelectedOnElement(WebElement element) {
		boolean select = element.isSelected();
		System.out.println("If The Element is Selected : " + select);
	}

	public static void getTitleOnPage() {
		String title = driver.getTitle();
		System.out.println("The Page Title is : " + title);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Page Url is : " + currentUrl);
	}

	public static void sleep(int a) throws InterruptedException {
		Thread.sleep(a);
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void windowClose() {
		driver.close();
	}

	public static void browserQuit() {
		driver.quit();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void screenMaximize() {
		driver.manage().window().maximize();
	}

	public static void screenFullscreen() {
		driver.manage().window().fullscreen();
	}

	public static void minimizeDimension(int x, int y) {
		Dimension dim = new Dimension(x, y);
		driver.manage().window().setSize(dim);
	}

	public static void minimizePosition(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (value.equalsIgnoreCase("visible")) {
			wait.until(ExpectedConditions.visibilityOf(element));
		} else if (value.equalsIgnoreCase("click")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} else {
			System.out.println("Wrong Wait");
		}
	}

	public static void simpleAlert(String value) {
		Alert a = driver.switchTo().alert();
		if (value.equalsIgnoreCase("ok")) {
			a.accept();
		} else if (value.equalsIgnoreCase("yes")) {
			a.accept();
		}
	}

	public static void confirmAlert(String value) {
		Alert a = driver.switchTo().alert();
		if (value.equalsIgnoreCase("ok")) {
			a.accept();
		} else if (value.equalsIgnoreCase("yes")) {
			a.accept();
		} else if (value.equalsIgnoreCase("cancel")) {
			a.dismiss();
		} else if (value.equalsIgnoreCase("no")) {
			a.dismiss();
		}
	}

	public static void promptAlert(String promalert, String value) {
		Alert a = driver.switchTo().alert();
		if (promalert.equalsIgnoreCase("ok")) {
			String t = a.getText();
			System.out.println("The Text In Prompt Alert is : " + t);
			a.sendKeys(value);
			a.accept();
		} else if (promalert.equalsIgnoreCase("cancel")) {
			String t = a.getText();
			System.out.println("The Text In Prompt Alert is : " + t);
			a.sendKeys(value);
			a.dismiss();
		}
	}

	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\VIGNESH S\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("gecko")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();

		return driver;
	}

	public static void screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\FACEBOOK_PROJECT\\Screenshot\\" + filename + ".png");
		FileUtils.copyFile(source, destination);
	}

	public static void jsScroll(int H, int V) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(" + H + "," + V + ")");
	}

	public static void jsScrollBy(int H, int V) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + H + "," + V + ")");
	}

	public static void jsScrollInToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void jsSendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);
	}

	public static void selectMethods(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.selectByIndex(n);
		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void deSelectMethods(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);
		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.deselectByIndex(n);
		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void selectIsMultiple(WebElement element) {
		Select s = new Select(element);
		boolean m = s.isMultiple();
		System.out.println("Is Multiple" + m);
	}

	public static void selectdeSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void selectfirstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement first = s.getFirstSelectedOption();
		System.out.println("The First Selected Option is : " + first);
	}

	public static void selectgetOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement oneoption : options) {
			System.out.println("The Options in DropDown is : " + oneoption);
		}
	}

	public static void selectgetallSelcted(WebElement element, String value) {
		Select s = new Select(element);
		List<WebElement> allselected = s.getAllSelectedOptions();
		for (WebElement select : allselected) {
			System.out.println("The Selected Options is : " + select);
		}
	}

	public static void actiondragAndDrop(WebElement element1, WebElement element2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element1, element1).perform();
	}

	public static void actionMethod(WebElement element, String value) {
		Actions a = new Actions(driver);
		if (value.equalsIgnoreCase("DC")) {
			a.doubleClick(element).perform();
		} else if (value.equalsIgnoreCase("CC")) {
			a.contextClick(element).perform();
		} else if (value.equalsIgnoreCase("CAH")) {
			a.clickAndHold(element).perform();
		} else if (value.equalsIgnoreCase("C")) {
			a.click(element).perform();
		} else if (value.equalsIgnoreCase("MTE")) {
			a.moveToElement(element).perform();
		} else if (value.equalsIgnoreCase("R")) {
			a.release(element).perform();
		} else {
			System.out.println("Wrong Action");
		}
	}

	public static void frames(String value) {
		if (value.equalsIgnoreCase("index")) {
			int f = Integer.parseInt(value);
			driver.switchTo().frame(f);
		} else if (value.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		} else if (value.equalsIgnoreCase("PF")) {
			driver.switchTo().parentFrame();
		} else if (value.equalsIgnoreCase("DC")) {
			driver.switchTo().defaultContent();
		} else {
			System.out.println("Wrong Frame");
		}
	}

	public static void framesElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void getWindowHandle() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
	}

	public static void getWindowTitle() {
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) {
			System.out.println(driver.switchTo().window(id).getTitle());
		}
	}

	public static void getWindowSwitch(String s) {
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) {
			if (driver.switchTo().window(id).getTitle().equalsIgnoreCase(s)) {
				break;
			}
		}
	}

	public static void robotClass(int n) throws AWTException {
		Robot r = new Robot();
		for (int i = 1; i <= n; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
}
