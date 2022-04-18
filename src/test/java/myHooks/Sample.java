package myHooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.app.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Sample extends BaseClass {

	@Before// (order=1)
	@Given("Login into the Application")
	public void login_into_the_application() {
		BaseClass.browserLaunch();
		System.out.println("TestOne Before");
	}
	
//	@Before ()
//	public void login_into_the_application1() {
//		
//		System.out.println("TestOne Before");
//	}

	@After()
	public void teardown() {
		

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("location" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
