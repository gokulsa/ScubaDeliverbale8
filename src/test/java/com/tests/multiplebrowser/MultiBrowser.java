package com.tests.multiplebrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MultiBrowser {
WebDriver driver;


@Test
@Parameters("browser")
public void setup(String browser) throws Exception{
//Check if parameter passed from TestNG is 'firefox'
if(browser.equalsIgnoreCase("firefox")){
//create firefox instan
WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();
driver.get("https://opensource-demo.orangehrmlive.com/");
driver.manage().window().maximize();
Thread.sleep(1000);

System.out.println("The Web Title is "+ driver.getTitle());

WebElement Username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
Username.sendKeys("Admin");
Thread.sleep(1500);

WebElement Pwd = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
Pwd.sendKeys("admin123");
Thread.sleep(500);



WebElement LoginButton = driver.findElement(By.className("button"));
LoginButton.click();



String LoginURL = driver.getCurrentUrl();
if(LoginURL.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"))
System.out.println("Verification - Login Successful");



WebElement Leave = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b"));
Leave.click();
Thread.sleep(500);



WebElement Entitlement = driver.findElement(By.xpath("//*[@id=\"menu_leave_Entitlements\"]")); //Entitlement dropdown
WebDriverWait wait = new WebDriverWait(driver, 300);
Actions builder = new Actions(driver);
builder.moveToElement(Entitlement).build().perform();
Thread.sleep(1000);



WebElement AddEntitlement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Add")));
AddEntitlement.click();
Thread.sleep(1000);



String AddLeaveURL = driver.getCurrentUrl();
if(AddLeaveURL.equals("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement"))
System.out.println("Verification - Add Leave Entitlement Page successfully opened");



WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_bulk_assign\"]"));
CheckBox.click();
Thread.sleep(1000);



WebElement Location = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_location\"]"));
Select Loc = new Select(Location);
Loc.selectByVisibleText(" Canadian Regional HQ");
Thread.sleep(1000);



WebElement Subunit = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_subunit\"]"));
Select Sub = new Select(Subunit);
Sub.selectByVisibleText(" Development");
Thread.sleep(1000);



WebElement LeaveType = driver.findElement(By.xpath("//*[@id=\"entitlements_leave_type\"]"));
Select LT = new Select(LeaveType);
LT.selectByVisibleText("CAN - Personal");
Thread.sleep(1500);



WebElement LeavePeriod = driver.findElement(By.xpath("//*[@id=\"period\"]"));
Select LP = new Select(LeavePeriod);
LP.selectByVisibleText("2022-01-01 - 2022-12-31");
Thread.sleep(1000);



WebElement DaysEntitlement = driver.findElement(By.xpath("//input[@name='entitlements[entitlement]']")); //Absolute xpath
DaysEntitlement.sendKeys("4");
Thread.sleep(4000);



WebElement SaveButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/p[1]/input[1]")); //Absolute xpath
SaveButton.click();
Thread.sleep(1000);



WebElement Confirm = driver.findElement(By.xpath("//*[@id=\"dialogConfirmBtn\"]"));
Confirm.click();
driver.quit();
}

//Check if parameter passed as 'chrome'
else if(browser.equalsIgnoreCase("chrome")){
//set path to chromedriver.exe
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/");
Thread.sleep(1000);



System.out.println("The Web Title is "+ driver.getTitle());



WebElement Username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
Username.sendKeys("Admin");
Thread.sleep(1500);



WebElement Pwd = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
Pwd.sendKeys("admin123");
Thread.sleep(500);



WebElement LoginButton = driver.findElement(By.className("button"));
LoginButton.click();



String LoginURL = driver.getCurrentUrl();
if(LoginURL.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"))
System.out.println("Verification - Login Successful");



WebElement Leave = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b"));
Leave.click();
Thread.sleep(500);



WebElement Entitlement = driver.findElement(By.xpath("//*[@id=\"menu_leave_Entitlements\"]")); //Entitlement dropdown
WebDriverWait wait = new WebDriverWait(driver, 300);
Actions builder = new Actions(driver);
builder.moveToElement(Entitlement).build().perform();
Thread.sleep(1000);



WebElement AddEntitlement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Add")));
AddEntitlement.click();
Thread.sleep(1000);



String AddLeaveURL = driver.getCurrentUrl();
if(AddLeaveURL.equals("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement"))
System.out.println("Verification - Add Leave Entitlement Page successfully opened");



WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_bulk_assign\"]"));
CheckBox.click();
Thread.sleep(1000);



WebElement Location = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_location\"]"));
Select Loc = new Select(Location);
Loc.selectByVisibleText(" Canadian Regional HQ");
Thread.sleep(1000);



WebElement Subunit = driver.findElement(By.xpath("//*[@id=\"entitlements_filters_subunit\"]"));
Select Sub = new Select(Subunit);
Sub.selectByVisibleText(" Development");
Thread.sleep(1000);



WebElement LeaveType = driver.findElement(By.xpath("//*[@id=\"entitlements_leave_type\"]"));
Select LT = new Select(LeaveType);
LT.selectByVisibleText("CAN - Personal");
Thread.sleep(1500);



WebElement LeavePeriod = driver.findElement(By.xpath("//*[@id=\"period\"]"));
Select LP = new Select(LeavePeriod);
LP.selectByVisibleText("2022-01-01 - 2022-12-31");
Thread.sleep(1000);



WebElement DaysEntitlement = driver.findElement(By.xpath("//input[@name='entitlements[entitlement]']")); //Absolute xpath
DaysEntitlement.sendKeys("4");
Thread.sleep(4000);



WebElement SaveButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/p[1]/input[1]")); //Absolute xpath
SaveButton.click();
Thread.sleep(1000);



WebElement Confirm = driver.findElement(By.xpath("//*[@id=\"dialogConfirmBtn\"]"));
Confirm.click();
Thread.sleep(7000);



driver.quit();
}
}
}