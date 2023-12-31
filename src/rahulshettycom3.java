import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class rahulshettycom3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");


		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");

		// WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String password = resetpassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(name);

		driver.findElement(By.name("inputPassword")).sendKeys(password);

		driver.findElement(By.className("signInBtn")).click();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.tagName("p")).getText());

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");

		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		driver.close();


	}


public static String resetpassword(WebDriver driver) throws InterruptedException {
	

	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.get("https://rahulshettyacademy.com/locatorspractice/");

	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div/button[2]")).click();
	String resetpassword = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
	String[] arraypass =resetpassword.split("'");
	//String[] arraypass2=arraypass[1].split("'");
	String password = arraypass[1].split("'")[0];
	return password;
	
	
	
	
	

	}

}

