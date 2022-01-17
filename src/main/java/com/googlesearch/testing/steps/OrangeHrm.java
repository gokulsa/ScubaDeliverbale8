package com.googlesearch.testing.steps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class OrangeHrm
{
	public static WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com";
	@Given("user launches Orange HRM website")
	public void user_launches_Orange_HRM_website() throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String string, String string2) throws Throwable
	{
		WebElement uname = driver.findElement(By.id("txtUsername"));
		uname.sendKeys("Admin");
		WebElement passwd = driver.findElement(By.id("txtPassword"));
		passwd.sendKeys("admin123");
	}
	@And("click on Submit button")
	public void click_on_Submit_button() throws Throwable 
	{
		WebElement submit = driver.findElement(By.id("btnLogin"));
		submit.click();
	}
	@Then("click on Maintenance")
	public void click_on_maintenance() throws Throwable
	{
		WebElement maintain = driver.findElement(By.xpath("//*[@id=\"menu_maintenance_purgeEmployee\"]/b"));
		maintain.click();
		Thread.sleep(3000);
	}
	@And("click on Access Records")
	public void click_on_accessrecords() throws Throwable
	{
		driver.findElement(By.id("menu_maintenance_accessEmployeeData")).click();
	}
	@When("user enters valid pwd {string}")
	public void user_enters_valid_pwd(String string3) throws Throwable
	{
		WebElement Verifypwd = driver.findElement(By.xpath("//*[@id=\"confirm_password\"]"));
		Verifypwd.sendKeys("admin123");
	}
	@And("click on Verify")
	public void click_on_verify() throws Throwable
	{
		WebElement Verifybtn = driver.findElement(By.xpath("//*[@id=\"frmPurgeEmployeeAuthenticate\"]/div/div/input"));
		Verifybtn.click();
	}
	
	@When("user enters valid name {string}")
	public void user_enters_valid_name(String string4) throws Throwable
	{
		WebElement ename = driver.findElement(By.xpath("//*[@id=\"employee_empName\"]"));
		ename.sendKeys("Goutam Ganes");
		Thread.sleep(4000);
	}
	@And("click on name")
	public void click_on_name() throws Throwable
	{
		WebElement nameclc = driver.findElement(By.xpath("/html/body/div[4]/ul/li/strong"));
		nameclc.click();
		Thread.sleep(5000);
	}
	@Then("click on search")
	public void click_on_search() throws Throwable
	{
		WebElement Searchbtn = driver.findElement(By.xpath("//*[@id=\"frmAccessEmployeeData\"]/div/div/input"));
		Searchbtn.click();
		Thread.sleep(3000);
		JavascriptExecutor ContinueScroll = (JavascriptExecutor) driver;
		ContinueScroll.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
	}
	@And("click on Download")
	public void click_on_Download() throws Throwable
	{
		driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
		Thread.sleep(1000);
	}
	@Then("click on Confirm Download")
	public void click_on_Confirm_Download() throws Throwable
	{
		driver.findElement(By.xpath("//*[@id=\"modal_confirm\"]")).click();
		Thread.sleep(3000);
		JavascriptExecutor ContinueScroll = (JavascriptExecutor) driver;
		ContinueScroll.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(2000);
	}
	@And("click on Welcome button")
	public void click_on_welcome_button() throws Throwable
	{
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		Thread.sleep(3000);
	}
	@Then("click on Logout button")
	public void click_on_logout_button() throws Throwable
	{
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
	}
	@And("close browser")
	public void close_browser() throws Throwable
	{
		driver.quit();
	}
}