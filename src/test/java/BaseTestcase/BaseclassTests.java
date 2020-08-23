package BaseTestcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AssignCases.Testcases;

public class BaseclassTests {

	WebDriver driver;

	@Test
	public void cases() throws InterruptedException, IOException {
		Testcases tests = new Testcases(driver);
		tests.facebook_login();
		tests.uploadstatus();
		tests.storycreate();
	}

}

