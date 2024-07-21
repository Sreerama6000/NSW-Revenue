package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.MediaRelease;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	public WebDriver driver;
	public MediaRelease medrel;

	@Given("user launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		medrel= new MediaRelease(driver);
		driver.manage().window().maximize();
	    
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		
		
	    
	}

	@When("user selects Minister {string}")
	public void user_selects_minister(String Selection) {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.SelectMinister(Selection);
	    
	    
	}

	@When("click ApplyAllFilters")
	public void click_apply_all_filters() {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.ApplyFilters();
	    
	}

	@Then("it should display correct results for {string}")
	public void it_should_display_correct_results_for(String Selectedoption) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String URL= driver.getCurrentUrl();
	    if(URL.contains(Selectedoption))
	    		{
	    	Assert.assertTrue(true);
	    		}
	    else
	    {
	    	Assert.assertFalse(false);
	    }
	    	    
	}

	@Then("click on ClearFilters")
	public void click_on_clear_filters() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.ClearFilters();
	    
	}
	@Then("it should display correct details")
	public void it_should_display_correct_details()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		medrel.verifyclearfilters();
	}
	

	@Then("close browser")
	public void close_browser() {
		
		driver.close();
		driver.quit();
	    
	}


}
