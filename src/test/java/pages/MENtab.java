package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MENtab {
	WebDriver d;
	Actions a;

	public MENtab(WebDriver d) {
		this.d = d;

		PageFactory.initElements(d, this);
		a = new Actions(d);
	}

	@FindBy(xpath = "//header/div[2]/nav[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement MENtab;

	@FindBy(xpath = "//a[contains(text(),'Fashion Accessories')]")
	public WebElement FashionAccessories;

	@FindBy(xpath = "//a[contains(text(),'Phone Cases')]")
	public WebElement PhoneCases;

	@FindBy(xpath = "//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]/section[1]/ul[1]/li[13]/a[1]/div[1]/div[1]")
	public WebElement Item3;

	@FindBy(xpath = "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[1]")
	public WebElement AddToBag;

	@FindBy(xpath = "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/p[1]/span[1]")
	public WebElement Price;

	public void menTab() throws InterruptedException {
		a.moveToElement(MENtab).perform();
		Thread.sleep(2000);
		// a.moveToElement(FashionAccessories).perform();
		a.moveToElement(PhoneCases).click().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.ARROW_DOWN).perform();
		a.sendKeys(Keys.ARROW_DOWN).perform();
	    a.sendKeys(Keys.ARROW_DOWN).perform();
		
		Item3.click();
	}

	public int getPrice() {	
		int price = 0;		
		String str = Price.getText();
		str = str.replaceAll("[^\\d]", "");
		price = Integer.parseInt(str);
		return price;
	}

}
