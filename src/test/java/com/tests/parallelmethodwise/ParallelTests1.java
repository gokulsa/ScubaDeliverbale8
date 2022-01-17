package com.tests.parallelmethodwise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.scuba.helper.ExtentReportManager;
import com.scuba.helper.WebUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTests1 {
public static ExtentReports extent;
public static ExtentTest test;
public static ExtentSparkReporter spark;


@BeforeMethod
public void setUp() {
extent = ExtentReportManager.getReports();
}

@Test
@Parameters({ "browser", "testname" })
public void Test1(String browser, String testname) throws IOException, InterruptedException {
test = extent.createTest(testname);
test.log(Status.INFO, "Starting execution of chrome test case");
System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
System.out.println("Execution Method Test1 from Parallel Tests Class");
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://www.saucedemo.com/");
Thread.sleep(1000);
WebElement Username = driver.findElement(By.id("user-name"));
Username.sendKeys("standard_user");
WebElement Pwd = driver.findElement(By.name("password"));
Pwd.sendKeys("secret_sauce");
WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
LoginBtn.click();
Thread.sleep(2000);
String logo = driver.getTitle();
if(logo.equals("SWAG LABS"));
System.out.println("Home page verification successful");
Thread.sleep(1000);
WebElement AddCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
AddCart.click();
Thread.sleep(2000);
WebElement YourCart = driver.findElement(By.className("shopping_cart_link"));
YourCart.click();
Thread.sleep(1000);
WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
Checkout.click();
Thread.sleep(1000);
WebElement FirstName = driver.findElement(By.id("first-name"));
FirstName.sendKeys("Gokul");
Thread.sleep(1000);
WebElement LastName = driver.findElement(By.name("lastName"));
LastName.sendKeys("Sankar");
Thread.sleep(1000);
WebElement Zipcode = driver.findElement(By.cssSelector("#postal-code"));
Zipcode.sendKeys("624152");
Thread.sleep(1000);
JavascriptExecutor ContinueScroll = (JavascriptExecutor) driver;
ContinueScroll.executeScript("window.scrollBy(0,250)", "");
Thread.sleep(1000);
WebElement ContinueBtn = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
ContinueBtn.click();
Thread.sleep(1000);
JavascriptExecutor FinishScroll = (JavascriptExecutor) driver;
FinishScroll.executeScript("window.scrollBy(0,250)", "");
Thread.sleep(1000);
WebElement FinishBtn = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
FinishBtn.click();
Thread.sleep(1000);
WebElement BackHomeBtn = driver.findElement(By.name("back-to-products"));
BackHomeBtn.click();
Thread.sleep(1000);
WebElement MenuBtn = driver.findElement(By.id("react-burger-menu-btn"));
MenuBtn.click();
Thread.sleep(1000);
WebElement LogoutBtn = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
LogoutBtn.click();





//test.log(Status.INFO, "Started the browser");
WebUtils.takeSnapshot(driver, "target/screenshots/test1.png");
Thread.sleep(10000);
driver.close();
}
}

