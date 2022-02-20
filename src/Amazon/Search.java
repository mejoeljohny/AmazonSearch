package Amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");

		// Maximize window
		driver.manage().window().maximize();

		// wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// to search for iPhone 12 in amazon
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iPhone 12");
		WebElement searchclk = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchclk.click();

		// to get the Iphone 12 names
		List<WebElement> names = driver.findElements(By.xpath("//*[contains(text(),'iPhone 12')]/parent::a"));

		// to get the Iphone 12 prices
		List<WebElement> prices = driver.findElements(By.xpath("//*[@class='a-price-whole']"));

		// To print the count of search results
		System.out.println("There are " + names.size() + " Search Results.");

		// Page Scroll down
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// to print the Iphone details
		System.out.println("Iphone Details are below : ");

		for (int count = 0; count < names.size(); count++) {
			if (names.get(count).getText().toLowerCase().contains("iphone 12"))
				System.out.println(" " + names.get(count).getText() + " - " + prices.get(count).getText());
		}
		driver.close();
	}

}
