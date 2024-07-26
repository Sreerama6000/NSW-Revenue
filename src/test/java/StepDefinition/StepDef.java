package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.MediaRelease;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	public WebDriver driver;
	public MediaRelease medrel;
	
	@Given("user launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		
		
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		medrel= new MediaRelease(driver);
		driver.get(url);
	}

	@When("user selects Minister {string}")
	public void user_selects_minister(String Selection) throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.SelectMinister(Selection);
	}
	@When("user click ApplyAllFilters")
	public void user_click_apply_all_filters() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.Filtersapply();
	}
	@Then("it should display correct results for {string}")
	public void it_should_display_correct_results_for(String Selectedoption) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String URL= driver.getCurrentUrl();
		
		{
			Assert.assertTrue(URL.contains(Selectedoption));
		}
		//else
		//{
			//Assert.assertFalse("Incorrect Details", false);;
		//}
	}
	@Then("user click on ClearFilters")
	public void user_click_on_clear_filters() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.ClearFilters();
	}
	@Then("it should display correct details")
	public void it_should_display_correct_details()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.verifyclearfilters();
	}
	
	@Then("close Browser")
	public void close_browser() {
		driver.close();
		
	    
	}
}



