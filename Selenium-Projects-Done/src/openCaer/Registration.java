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
import org.openqa.selenium.support.ui.Select;

public class Registration {

	public static void ScreenopencartReg(WebDriver driver, String test) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File srcFile = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./ScreeshotopencartReg/" + test + ".png"));

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("mann");
		driver.findElement(By.id("input-lastname")).sendKeys("123");
		driver.findElement(By.id("input-email")).sendKeys("manudliff@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("6234568985");
		driver.findElement(By.id("input-password")).sendKeys("Mann123");
		driver.findElement(By.id("input-confirm")).sendKeys("Mann123");
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		/*
		 * driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * 
		 * //driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a"))
		 * .click(); //Thread.sleep(1000);
		 * 
		 * //driver.findElement(By.id("input-username")).sendKeys("mann123");
		 * driver.findElement(By.id("input-firstname")).sendKeys("mann");
		 * driver.findElement(By.id("input-lastname")).sendKeys("123");
		 * driver.findElement(By.id("input-email")).sendKeys("manudliff@gmail.com");
		 * driver.findElement(By.id("input-telephone")).sendKeys("6234568985");
		 * driver.findElement(By.id("input-password")).sendKeys("Mann123");
		 * driver.findElement(By.id("input-confirm")).sendKeys("Mann123");
		 * driver.findElement(By.name("newsletter")).click();
		 * driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		 */

		ScreenopencartReg(driver, "Registration successful");

		// driver.quit();

	}

}
