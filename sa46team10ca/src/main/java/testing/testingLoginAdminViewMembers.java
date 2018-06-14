package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testingLoginAdminViewMembers {

public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
	
	WebDriver driver = new FirefoxDriver();
	driver.get("http://localhost:8080/ca/");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("james");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");

	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/div/ul/li[3]/a")).click();
	Thread.sleep(8000);
	driver.quit();
}
}
