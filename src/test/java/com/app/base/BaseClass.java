package com.app.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.annotation.XmlAttachmentRef;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public static WebDriver driver;
	private static Object File;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;

	//@org.junit.BeforeClass
	@BeforeClass
	public static void browserLaunch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAPPY\\eclipse-workspace\\Selenium\\Driver2\\chromedriver.exe");
		driver = new ChromeDriver();

		dataFromProperty("url");
		driver.manage().window().maximize();

		// reporter = new ExtentHtmlReporter("./addcatinhotel"+new
		// SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+ ".html");
		// // extent object
		// extent = new ExtentReports();
		// // object location merge
		// extent.attachReporter(reporter);

	}

	//@AfterClass
	@org.testng.annotations.AfterClass
	public static void browserClose() {
		// driver.close();
		System.out.println("After Class");
	}

	//@Before
	@BeforeMethod
	public void date() {
		Date date = new Date();
		System.out.println(date);
	}

	//@After
	@AfterMethod
	public void afterMethod() {
		// extent.flush();
		try {
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String format = d.format(new Date());
			File f = new File("location" + format + ".jpeg");
			TakesScreenshot tk = (TakesScreenshot) driver;
			java.io.File screenshotAs = tk.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshotAs, f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("after");
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void clearData(WebElement clearData) {
		clearData.clear();
	}

	public static void buttonClick(WebElement element) {
		element.click();

	}

	public static void submitMethod(WebElement element) {
		element.submit();
	}

	public static void cAlert() {
		// confirm alert
		Alert cAlert = driver.switchTo().alert();
		cAlert.dismiss();

	}

	public static void alert() {
		// normal alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void pAlert(String data) {
		// prompt alert
		Alert pAlert = driver.switchTo().alert();
		pAlert.sendKeys(data);
		pAlert.accept();

	}

	public static void screenshot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File ScreenshotAs = tk.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ScreenshotAs, new File(path));

	}

	public static void action_Rclick(WebElement element) {
		// For context,
		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public static void action_Dclick(WebElement element) {
		// For double click.
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	public static void action_DD(WebElement element1, WebElement element2) {
		// For drag and drop
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2);

	}

	public static void action_MtoElement(WebElement element) {
		// For mouse move to element
		Actions action = new Actions(driver);
		action.moveToElement(element);

	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor jsClick = (JavascriptExecutor) driver;
		jsClick.executeScript("arguments[0].click()", element);
	}

	public static void jsGetAttribute(WebElement element) {
		JavascriptExecutor jsGetAttribute = (JavascriptExecutor) driver;
		Object executeScript = jsGetAttribute.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println("My data is :" + executeScript);
	}

	public static void jsSetAttribute(String data, WebElement element) {
		JavascriptExecutor jsSetAttribute = (JavascriptExecutor) driver;
		jsSetAttribute.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public static void jsScroll(int y) {
		JavascriptExecutor jsScroll = (JavascriptExecutor) driver;
		jsScroll.executeScript("window.scroll(0,'" + y + "')");
	}

	public static void dropDownIndex(WebElement element, int a) {
		// For Drodown;
		Select dropDown = new Select(element);
		dropDown.selectByIndex(a);

	}

	public static void dropDownvalue(WebElement element, String a) {
		// For Drodown;
		Select dropDown = new Select(element);
		dropDown.selectByValue(a);

	}

	public static void dropDownText(WebElement element, String a) {
		// For Drodown;
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(a);

	}

	public static void frame(int data) {
		driver.switchTo().frame(data);
	}

	public static void parentFrame() {
		driver.switchTo().defaultContent();
	}

	public static void getText(WebElement element) {
		System.out.println(element.getText());
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	public static String dataFromexcel(int rowdata, int cellData) {
		// locate the file
		String value = null;
		try {
			File f = new File("C:\\Users\\HAPPY\\Downloads\\Project_Class\\src\\test\\resources\\TestData\\Book1.xlsx");
			// reading the file
			FileInputStream fis = new FileInputStream(f);
			// Workbook I -> pass the file getSheet()
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// to fetch all dats from excel getPhysicalnumberofRows() and
			// getPhysicalnumberofCells()
			Row row = sheet.getRow(rowdata);
			Cell cell = row.getCell(cellData);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();

			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					// 19-Mar-2022 19-02-2022
					SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
					value = s.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					long a = (long) numericCellValue;
					value = String.valueOf(a);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public static void dataFromProperty(String data) {
		try {
			File f = new File(
					"C:\\Users\\HAPPY\\Downloads\\Project_Class\\src\\test\\resources\\TestData\\file.properties");
			FileReader fr = new FileReader(f);
			Properties pr = new Properties();
			pr.load(fr);
			String property = pr.getProperty(data);
			driver.get(property);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void dataFromPropertyElement(String data, WebElement d) {
		try {
			File f = new File(
					"C:\\Users\\HAPPY\\Downloads\\Project_Class\\src\\test\\resources\\TestData\\file.properties");
			FileReader fr = new FileReader(f);
			Properties pr = new Properties();
			pr.load(fr);
			String property = pr.getProperty(data);
			d.sendKeys(property);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void childwindo() {
		Set<String> winHandles = driver.getWindowHandles();
		for (String wind : winHandles) {
			driver.switchTo().window(wind);
		}
	}

	public static void parntwindo() {
		String Parent = driver.getWindowHandle();
		driver.switchTo().window(Parent);
	}

	public static void enter(WebElement element) {
		try {
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pageEnd(WebElement element) {
		try {
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_END);
			ro.keyRelease(KeyEvent.VK_END);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	// 1.scenario for FindElement
	// WebElement findElement = driver.findElement(By.xpath(""));
	public static WebElement findElementByname(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findElementByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// 2. scenario for FindElement
	// create a method using abtract class as argument
	public static WebElement findEle(By ab) {
		return driver.findElement(ab);

	}

	public static void sendData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}

}
