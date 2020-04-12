package com;



import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SnapdealTest {

	static WebDriver driver;
	
	@BeforeClass
	public void startmethod()
	{
		System.setProperty("webdriver.chrome.driver", "./target/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=0)
	public void MobileTabwithSmartphones() throws IOException, InterruptedException {
		
		ElementsStorage web=new ElementsStorage(driver);
		System.out.println(web.MobileTab.getText());
		
		Actions act=new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		act.moveToElement(web.MobileTab).build().perform();
		act.moveToElement(web.SmartPhones).click().build().perform();
		
		System.out.println(web.SmartPhones.getText());
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void SelectingPriceRange() throws IOException, InterruptedException
	{
		
		ElementsStorage web=new ElementsStorage(driver);
		
		web.StartpointSlider.click();
		web.StartpointSlider.sendKeys(Keys.BACK_SPACE,Keys.DELETE,Keys.BACK_SPACE,Keys.DELETE,"10000");
		
		web.EndpointSlider.click();
		web.EndpointSlider.sendKeys(Keys.BACK_SPACE,Keys.DELETE,Keys.BACK_SPACE,Keys.DELETE,Keys.DELETE,"20000");
		
		web.Go.click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void SelectingBrands() throws IOException, InterruptedException
	{
		ElementsStorage web=new ElementsStorage(driver);
		
		web.Brands.click();
		Thread.sleep(3000);
		web.A.click();
		web.B.click();
		web.C.click();
		web.Apply.click();
		
		Thread.sleep(3000);
	
	}
	
	@Test(priority=3)
	public void Mobiles() throws IOException, InterruptedException
	{
		ElementsStorage web=new ElementsStorage(driver);
		
		web.Mobile1.click();
		web.Windows();
				
		web.Mobile2.click();
		web.Windows();
				
		web.Mobile3.click();
		web.Windows();
		
	}
	
	@Test(priority=4)
	public void OneItemRemovedFromCart() throws IOException, InterruptedException
	{
		ElementsStorage web=new ElementsStorage(driver);
		
		web.FinalCart.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		web.Removeitem.click();
		
		Thread.sleep(3000);
		
	}
	
	@Test(dependsOnMethods= {"OneItemRemovedFromCart"})
	public void Screenshot() throws IOException, InterruptedException
	{
		File location= new File("./target/screenshot.png");
		File original= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(original, location);
		Thread.sleep(2000);
		
	}

		
	@AfterClass
	public void finalmethod()
	{
			driver.quit();	

	}
	
	}

