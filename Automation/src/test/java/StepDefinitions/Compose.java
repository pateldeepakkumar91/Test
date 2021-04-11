package StepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;

public class Compose {

	WebDriver driver = null;


	@Given("User is on gmail login page")
	public void user_is_on_gmail_login_page() {
		System.setProperty("webdriver.chrome.driver", "F:/Test/Automation/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.Gmail.com");


	}

	@Given("user enters username and clicks on next button")
	public void user_enters_username_and_clicks_on_next_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sandeep.infosel@gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	@Given("user enters password and clicks on next button")
	public void user_enters_password_and_clicks_on_next_button() {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pr@chinaik@123");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
	}


	@And("user able to see gmail homepage")
	public void user_able_to_see_gmail_homepage() {
		System.out.println("user is on gmail page");
	}

	@When("User clicks on compose button")
	public void user_clicks_on_compose_button() {
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	}

	@Then("User able to New message pop-up")
	public void user_able_to_new_message_pop_up() {
		Set<String> handler	=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String ParentWindowId=it.next();
		String ChildtWindowId=it.next();
		driver.switchTo().window(ChildtWindowId);

	}

	@Then("enter all relevent data in the fields")
	public void enter_all_relevent_data_in_the_fields() {
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("mail");
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Hello World");

	}

	@Then("clicks on send button")
	public void clicks_on_send_button() {
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3 T-I-JW']")).click();
	}

}
