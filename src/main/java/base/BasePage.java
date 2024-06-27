package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasePage {
	public static ChromeDriver driver;
	public static ExtentSparkReporter sparkreport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp()
	{
		sparkreport=new ExtentSparkReporter("./reports/flipkart.html");
		sparkreport.config().setDocumentTitle("Flipkart Functional Testing");
		sparkreport.config().setReportName("Flipkart");
		sparkreport.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.setSystemInfo("TesterName", "Bimal Singh");
		report.setSystemInfo("Environment", "Test Env");
		report.attachReporter(sparkreport);
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	private ExtentReports setSystemInfo(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void openUrl()
	{
		driver.get("http://www.flipkart.com");
	}
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
		report.flush();
	}

}
