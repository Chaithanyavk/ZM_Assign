package AssignCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcases {
	static WebDriver driver;

	By email_id = By.id("email");
	By pw = By.id("pass");
	By login = By.xpath("//button[@name='login']");
	By create = By.xpath("//div[@aria-label='Create']");
	By status = By.xpath("//span[contains(text(),'Share a post on News Feed.')]");
	By status_text = By.xpath("//div[@class=\"_1mf _1mj\"]");
	By post_btn = By.xpath("//div[contains(text(),'Post')]");
	By story = By.xpath("//span[contains(text(),'Story')]");
	By story_text = By.xpath("//div[contains(text(),'Create a Text Story')]");
	By enter_text = By.id("jsc_c_dz");
	By share_btn = By.xpath("//span[contains(text(),'Share to Story')]");
	public Testcases(WebDriver driver) {
		this.driver=driver;
	}
	
	public void facebook_login() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		File file=new File("configs/testData.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties p=new Properties();
		p.load(fis);
		String emailid=p.getProperty("Email");
		String password=p.getProperty("Password");
		driver.findElement(email_id).sendKeys(emailid);
		driver.findElement(pw).sendKeys(password);
		driver.findElement(login).click();
		Thread.sleep(2000);
		
	}
	public void uploadstatus() throws InterruptedException {
		driver.findElement(create).click();
		driver.findElement(status).click();
		driver.findElement(status_text).sendKeys("Helloworld");
		driver.findElement(post_btn).click();
		
	}
	public void storycreate() {
		driver.findElement(create).click();
		driver.findElement(story).click();
		driver.findElement(story_text).click();
		driver.findElement(enter_text).sendKeys("Helloworld");
		driver.findElement(share_btn).click();
	}
		
	}
	
	


