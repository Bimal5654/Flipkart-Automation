package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLoginPage {
	ChromeDriver driver;
	By emailid=By.name("email");
	By passwd=By.name("pass");
	By loginbtn=By.name("login");
	
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}
	public void login()
	{
		driver.findElement(emailid).sendKeys("bsingh993635@gmail.com");
		driver.findElement(passwd).sendKeys("Bimal@5654");
		driver.findElement(loginbtn).click();
	}
	public void validatesuccess()
	{
		System.out.println("code to validate the success login");
	}

}
