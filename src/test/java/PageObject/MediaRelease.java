package PageObject;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	@FindBy(xpath = "//*[@id=\"block-content\"]/article/section[3]/div/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div[4]/div/button")
	WebElement ClearFilters;
	@FindBy(xpath = "//*[@id=\"block-content\"]/article/section[3]/div/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div[2]")
	WebElement Ministers;



	public void SelectMinister(String Selection) throws Exception
	{
		if(Selection.contains("The Premier"))
		{

			WebDriverWait wait = new WebDriverWait(ldriver,30);
			wait.until(ExpectedConditions.elementToBeClickable(FilterThePremier));
			//FilterThePremier.click();
			JavascriptExecutor jse = (JavascriptExecutor)ldriver;
			jse.executeScript("arguments[0].scrollIntoView(true);", FilterThePremier);
			//try{
				jse.executeScript("arguments[0].click();", FilterThePremier);
			//}catch (Exception e) {
				//System.out.println("Register element is not found.");
				//throw(e);
			//}
				//boolean FilterSelection = FilterThePremier.isSelected();
				//if(FilterSelection == true)
				//{
			//Assert.assertTrue(FilterThePremier.isSelected());
			//	}

		}

		else if(Selection.contains("Deputy Premier"))
		{
			WebDriverWait wait = new WebDriverWait(ldriver,30);
			wait.until(ExpectedConditions.elementToBeClickable(FilterDeputyPremier));
			JavascriptExecutor jse = (JavascriptExecutor)ldriver;
			//try{
				jse.executeScript("arguments[0].click();", FilterDeputyPremier);
			//}catch (Exception e) {
				//System.out.println("Register element is not found.");
				//throw(e);
			//}
			//Assert.assertEquals(true,FilterDeputyPremier.getAttribute("Checked"));
			//FilterDeputyPremier.click();
		}
		else if(Selection.contains("Treasurer"))
		{
			WebDriverWait wait = new WebDriverWait(ldriver,30);
			wait.until(ExpectedConditions.elementToBeClickable(FilterTreasurer));
			JavascriptExecutor jse = (JavascriptExecutor)ldriver;
			jse.executeScript("arguments[0].click();", FilterTreasurer);
			
			}


		else if(Selection.contains("Minister for Aboriginal Affairs and Treaty"))
		{
			//FilterMinisterforAboriginalAffairsandTreaty.click();
			JavascriptExecutor jse = (JavascriptExecutor)ldriver;
			//try{
				jse.executeScript("arguments[0].click();", FilterMinisterforAboriginalAffairsandTreaty);
			//}catch (Exception e) {
				//System.out.println("Register element is not found.");
				//throw(e);
			//}
			//Assert.assertEquals(true,FilterMinisterforAboriginalAffairsandTreaty.getAttribute("Checked"));
		}
		else if(Selection.contains("Minister for Agriculture"))
		{
			//FilterMinisterofAgriculture.click();
			JavascriptExecutor jse = (JavascriptExecutor)ldriver;
			//try{
				jse.executeScript("arguments[0].click();", FilterMinisterofAgriculture);
			//}catch (Exception e) {
				//System.out.println("Register element is not found.");
				//throw(e);
			//}
			//Assert.assertEquals(true,FilterMinisterofAgriculture.getAttribute("Checked"));
		}
		}
	public void Filtersapply() 
	{
		//ApplyFilters.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(ldriver,1000);
		wait.until(ExpectedConditions.elementToBeClickable(ApplyFiltersbtn));
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click();", ApplyFiltersbtn);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	public void ClearFilters()
	{
		//ClearFilters.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(ldriver,100);
		wait.until(ExpectedConditions.elementToBeClickable(ClearFilters));
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click();", ClearFilters);
		
	}
	public void verifyclearfilters()

	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(FilterThePremier.isSelected());
		Assert.assertFalse(FilterDeputyPremier.isSelected());
		Assert.assertFalse(FilterTreasurer.isSelected());
		Assert.assertFalse(FilterMinisterforAboriginalAffairsandTreaty.isSelected());
		Assert.assertFalse(FilterMinisterofAgriculture.isSelected());
	}
}







