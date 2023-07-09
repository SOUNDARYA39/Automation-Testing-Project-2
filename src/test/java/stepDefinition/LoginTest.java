package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   }
	
	
	@Given("I want to load the application")
	public void i_want_to_load_the_application() {
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");  
		
	}
	
	@When("The login page is displayed enter valid username and password")
	public void the_login_page_is_displayed_enter_valid_username_and_password() {
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// driver.switchTo().alert().dismiss();
	    
	}
	
	@When("Click on login button")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.id("submitButton")).click();
		 driver.switchTo().alert().dismiss();
		 Thread.sleep(2000);
	    
	  
	}
	@Then("Verify for home page displayed or not")
	public void verify_for_home_page_displayed_or_not() throws Throwable {
		
		Thread.sleep(2000);
		String actualTitle=" Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle, "login page is not displayed");
		sa.assertAll();
		
		
	   
	}

}
