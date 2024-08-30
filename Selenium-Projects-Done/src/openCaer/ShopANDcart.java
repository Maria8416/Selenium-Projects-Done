package openCaer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ShopANDcart {
	
	
	public static void Screenshotss(WebDriver driver,String test) throws IOException {
		
		TakesScreenshot shorts=(TakesScreenshot)driver;
		File srcFile = shorts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./ScrrenshotloginShop/"+test+".png"));
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("input-email")).sendKeys("manudliff@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Mann123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Screenshotss(driver, "Login Success");
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='https://naveenautomationlabs.com/opencart/image/cache/catalog/demo/imac_1-228x228.jpg']")).click();
		driver.findElement(By.id("button-cart")).click();
		Screenshotss(driver, " Added to cart");
		Thread.sleep(1000);
		
		driver.findElement(By.id("cart-total")).click();
		driver.findElement(By.linkText("View Cart")).click();
		Screenshotss(driver, " Cart items");
		
		System.out.println("ok");
		driver.quit();
		
		
		
	}

}
