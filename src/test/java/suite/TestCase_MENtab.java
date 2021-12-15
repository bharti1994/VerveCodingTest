package suite;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.Common;
import pages.MENtab;

public class TestCase_MENtab extends Common {

	@Test
	public void menTab() throws InterruptedException {
		MENtab mt = new MENtab(d);
		d.get("https://www.myntra.com/");
		Thread.sleep(2000);

		mt.menTab();

		String handle1 = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		String handle[] = new String[handles.size()];

		for (String h : handles) {
			System.out.println(h);
			if (handle1.equals(h)) {
				handle[0] = h;
			} else {
				handle[1] = h;
			}
		}
		Thread.sleep(4000);
		d.switchTo().window(handle[1]);
		mt.AddToBag.isDisplayed();
		int productPrice = mt.getPrice();
		System.out.println(productPrice);
		if (productPrice > 10) {
			mt.Price.isDisplayed();
		}

	}

}
