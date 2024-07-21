package PageObject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaRelease {

	WebDriver ldriver;

	public MediaRelease(WebDriver rDriver)
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//*[@id=\"filter-ministers\"]/div[1]/label")
	//@FindBy(xpath = "/html/body/div[1]/div/main/div[2]/article/section[3]/div/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div[2]/div/div/fieldset/div[2]/label")
	WebElement FilterThePremier;
	@FindBy(xpath = "//*[@id=\"filter-ministers\"]/div[2]/label")
	WebElement FilterDeputyPremier;
	@FindBy(xpath = "//*[@id=\"filter-ministers\"]/div[3]/label")
	WebElement FilterTreasurer;
	@FindBy(xpath = "//*[@id=\"filter-ministers\"]/div[4]/label")
	WebElement FilterMinisterforAboriginalAffairsandTreaty;
	@FindBy(xpath = "//*[@id=\"filter-ministers\"]/div[5]/label")
	WebElement FilterMinisterofAgriculture;
	@FindBy(xpath = "//input[@type='submit' and @value='Apply filters']")
	WebElement ApplyFiltersbtn;
	@FindBy(xpath = "/html/body/div[1]/div/main/div[2]/article/section[3]/div/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div[4]/div/button")
	WebElement ClearFilters;
	@FindBy(xpath = "//*[@id=\"block-content\"]/article/section[3]/div/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div[2]")
	WebElement Ministers;
	
	

public void SelectMinister(String Selection)
{
	if(Selection.contains("The Premier"))
	{
		
		
		//FilterThePremier.click();
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].scrollIntoView(true);", FilterThePremier);
		jse.executeScript("arguments[0].click();", FilterThePremier);
		Assert.assertEquals(true,FilterThePremier.getAttribute("Checked"));
				
	}
	else if(Selection.contains("Deputy Premier"))
	{
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click();", FilterDeputyPremier);
		Assert.assertEquals(true,FilterDeputyPremier.getAttribute("Checked"));
		//FilterDeputyPremier.click();
	}
	else if(Selection.contains("Treasurer"))
	{
		//ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FilterTreasurer.click();
		//JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", FilterTreasurer);
		//jse.executeScript("arguments[0].click();", FilterTreasurer);
		//Assert.assertEquals(true,FilterTreasurer.getAttribute("Checked"));
		
	}
	else if(Selection.contains("Minister for Aboriginal Affairs and Treaty"))
	{
		//FilterMinisterforAboriginalAffairsandTreaty.click();
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click();", FilterMinisterforAboriginalAffairsandTreaty);
		Assert.assertEquals(true,FilterMinisterforAboriginalAffairsandTreaty.getAttribute("Checked"));
	}
	else if(Selection.contains("Minister for Agriculture"))
	{
		//FilterMinisterofAgriculture.click();
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click();", FilterMinisterofAgriculture);
		Assert.assertEquals(true,FilterMinisterofAgriculture.getAttribute("Checked"));
	}
}
public void ApplyFilters()
{
	//ApplyFilters.click();
	JavascriptExecutor jse = (JavascriptExecutor)ldriver;
	jse.executeScript("arguments[0].click();", ApplyFiltersbtn);
	//ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	
}
public void ClearFilters()
{
	ClearFilters.click();
	JavascriptExecutor jse = (JavascriptExecutor)ldriver;
	jse.executeScript("arguments[0].click();", ClearFilters);
	ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
public void verifyclearfilters()
{
	Assert.assertFalse(FilterThePremier.isSelected());
	Assert.assertFalse(FilterDeputyPremier.isSelected());
	Assert.assertFalse(FilterTreasurer.isSelected());
	Assert.assertFalse(FilterMinisterforAboriginalAffairsandTreaty.isSelected());
	Assert.assertFalse(FilterMinisterofAgriculture.isSelected());
}
}







