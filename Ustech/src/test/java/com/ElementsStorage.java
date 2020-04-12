package com;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsStorage {
	
	WebDriver driver;
	
	public ElementsStorage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//div[@class='leftNavigationLeftContainer expandDiv']/ul/li[2]/a/span[2]")
	WebElement MobileTab;
	public WebElement MobileTab() {return MobileTab;}
	
	
	@FindBy(xpath="//div[@id='category2Data']/div/div/div/p[2]/a/span")
	WebElement SmartPhones;
	public WebElement SmartPhones() {return SmartPhones;}
	
	
	@FindBy(xpath="//input[@name='fromVal']")
	WebElement StartpointSlider;
	public WebElement StartpointSlider() {return StartpointSlider;}
	
	
	@FindBy(xpath="//input[@name='toVal']")
	WebElement EndpointSlider;
	public WebElement EndpointSlider() {return EndpointSlider;}
	
	
	@FindBy(xpath="//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")
	WebElement Go;
	public WebElement Home() {return Go;}
	
	
	@FindBy(xpath="//div[@id='645609718334']//img[contains(@class,'product-image wooble')]")
	WebElement Mobile1;
	public WebElement Mobile1() {return Mobile1;}

	
	@FindBy(xpath="//div[@id='640565844771']//img[contains(@class,'product-image wooble')]")
	WebElement Mobile2;
	public WebElement Mobile2() {return Mobile2;}
	

	@FindBy(xpath="//div[@id='6917529700656464488']//img[contains(@class,'product-image wooble')]")
	WebElement Mobile3;
	public WebElement Mobile3() {return Mobile3;}
	
	
	@FindBy(xpath="//i[@class='sd-icon sd-icon-cart-icon-white-2']")
	WebElement FinalCart;
	public WebElement FinalCart() {return FinalCart;}
	
	
	@FindBy(xpath="//span[@class='remove-item-shortlist']")
	WebElement Removeitem;
	public WebElement Remoteitem() {return Removeitem;}
	
	
	@FindBy(xpath="//input[@placeholder='Search by Brand']")
	WebElement Brands;
	public WebElement Brands() {return Brands;}
	
	
	@FindBy(xpath="//div[contains(@class,'topAdvFilters')]//div[4]//div[1]//label[1]")
	WebElement A;
	public WebElement A() {return A;}

	
	@FindBy(xpath="//div[contains(@class,'js-adv-filters adv-filters')]//div[14]//div[1]//label[1]")
	WebElement B;
	public WebElement B() {return B;}

	
	@FindBy(xpath="//div[contains(@class,'js-adv-filters adv-filters')]//div[15]//div[1]//label[1]")
	WebElement C;
	public WebElement C() {return C;}
	
	
	@FindBy(xpath="//div[contains(@class,'btn applyFilters lfloat')]")
	WebElement Apply;
	public WebElement Apply() {return Apply;}
	
	
	public void Windows() throws InterruptedException
	{
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> itr=ids.iterator();
		String parentid =itr.next();
		String childid =itr.next();
		
		driver.switchTo().window(childid);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='add-cart-button-id']")).click();
		driver.close();
		
		driver.switchTo().window(parentid);
		

	}



}
