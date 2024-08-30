package curaHealthcareService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeAppointment {
	
	public static void captScreen(WebDriver driver,String test) throws IOException {
        // Convert WebDriver object to TakeScreenshot
		TakesScreenshot Screen=(TakesScreenshot)driver;
		// Call getScreenshotAs method to create an image file
		File srcFile= Screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Screenshots/"+test+".png"));
		
	}
		    	
       
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.id("btn-make-appointment")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		Thread.sleep(1000);

		Select facility = new Select(driver.findElement(By.id("combo_facility")));
		facility.selectByVisibleText("Seoul CURA Healthcare Center");

		driver.findElement(By.id("radio_program_medicaid")).click();

		driver.findElement(By.id("txt_visit_date")).sendKeys("28/08/2014");
		
		driver.findElement(By.id("txt_comment")).sendKeys("Emergency");

		driver.findElement(By.id("btn-book-appointment")).click();
		captScreen(driver,"Appointment Confirmation");
		
		
		
		
		
		System.out.println("ok");
		
		
		
		driver.quit();

	}

}
