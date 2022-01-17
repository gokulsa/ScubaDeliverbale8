package com.tests.paralleltestwise;





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





public class ParallelTests {
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
driver.get("http://demo.guru99.com/test/newtours/register.php");
WebElement firstname = driver.findElement(By.name("firstName"));
WebElement lastname = driver.findElement(By.name("lastName"));
WebElement phone = driver.findElement(By.name("phone"));
WebElement mail = driver.findElement(By.name("userName"));
WebElement address = driver.findElement(By.name("address1"));
WebElement city = driver.findElement(By.name("city"));
WebElement state = driver.findElement(By.name("state"));
WebElement pincode = driver.findElement(By.name("postalCode"));
WebElement username = driver.findElement(By.name("email"));
WebElement pwd = driver.findElement(By.name("password"));
WebElement confirm_pwd = driver.findElement(By.name("confirmPassword"));
WebElement submit = driver.findElement(By.name("submit"));
firstname.sendKeys("KARTHICK");
Thread.sleep(3000);
lastname.sendKeys("Balasubramani");
Thread.sleep(3000);
phone.sendKeys("9876543210");
Thread.sleep(3000);
mail.sendKeys("karthickk@gmail.com");
Thread.sleep(3000);
address.sendKeys("no 6");
Thread.sleep(3000);
city.sendKeys("chennai");
Thread.sleep(3000);
state.sendKeys("TamilNadu");
Thread.sleep(3000);
pincode.sendKeys("602001");
Thread.sleep(3000);
username.sendKeys("mercury");
Thread.sleep(3000);
pwd.sendKeys("mercury");
Thread.sleep(3000);
confirm_pwd.sendKeys("mercury");
Thread.sleep(3000);
submit.click();
//test.log(Status.INFO, "Started the browser");
WebUtils.takeSnapshot(driver, "target/screenshots/test1.png");
Thread.sleep(10000);
driver.close();





}





@Test
@Parameters({ "browser", "testname" })
public void Test2(String browser, String testname) throws IOException, InterruptedException {
test = extent.createTest(testname);
test.log(Status.INFO, "Starting execution of chrome test case");
System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
System.out.println("Execution Method Test2 from Parallel Tests Class");
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

//To load orangehrm website
driver.get("https://opensource-demo.orangehrmlive.com/");
driver.manage().window().maximize();
Thread.sleep(2000);


//Verifying the page for heading and logo
String Login_Page_Title=driver.getTitle();
if(Login_Page_Title.equalsIgnoreCase("orangehrm"))
{
System.out.println("Page Title: "+Login_Page_Title);
System.out.println("Navigated to OrangeHRm Website");
}
else
System.out.println("Wrong website ");




while(Login_Page_Title.equalsIgnoreCase("orangehrm"))
{
WebElement Logo = driver.findElement(By.tagName("img"));
System.out.println("Is Orange HRM website logo visible?"+Logo.isDisplayed());





//Login to the page
WebElement Username = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
Username.sendKeys("Admin");
Thread.sleep(1500);

WebElement Pwd = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
Pwd.sendKeys("admin123");
Thread.sleep(500);



WebElement LoginButton = driver.findElement(By.className("button"));
LoginButton.click();



//Navigating to recruitment Tab
WebElement Recruitment_tab=driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule > b"));
Recruitment_tab.click();
Thread.sleep(1000);
driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
Thread.sleep(3000);
driver.findElement(By.name("btnAdd")).click();



WebElement checkbox_active = driver.findElement(By.name("addJobVacancy[status]"));
Thread.sleep(3000);
if((!checkbox_active.isSelected()))
checkbox_active.click();
System.out.println("The Vacancy State is active : "+checkbox_active.isSelected());
Thread.sleep(2000);
WebElement Publish = driver.findElement(By.name("addJobVacancy[publishedInFeed]"));
if((!Publish.isSelected()))
Publish.click();
System.out.println("The Vacancy Status is published : "+Publish.isSelected());
WebElement DropDown =driver.findElement(By.id("addJobVacancy_jobTitle"));
Thread.sleep(3000);
Select job=new Select(DropDown);
job.selectByValue("7");
WebElement option = job.getFirstSelectedOption();
String choosen = option.getText();





//Verifying the Selected option in drop down box is correct
if(choosen.equalsIgnoreCase("Software engineer"))
{
System.out.println("Selected option in dropdown is : "+choosen);
System.out.println("The Selected option is verified and it is correct");
}
else
System.out.println("Wrong Selection in Jobtitle dropdown box");
Thread.sleep(3000);






//Adding new vacancy details
driver.findElement(By.id("addJobVacancy_name")).sendKeys("Junior Software Engineer");
Thread.sleep(3000);
driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("David Morris");
Thread.sleep(3000);
driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("3");
Thread.sleep(3000);
driver.findElement(By.id("addJobVacancy_description")).sendKeys("Integrate software applications into a variety of existing customer platforms using open source tools and technologies; Apply and perform systems analysis, modeling and simulation of processing systems and demonstrate systems via simulated and/or real data input");
Thread.sleep(3000);
driver.findElement(By.id("btnSave")).click();
driver.findElement(By.id("btnBack")).click();
Thread.sleep(5000);





//Searching Vacancy
WebElement Job_Title = driver.findElement(By.name("vacancySearch[jobTitle]"));
Select objj=new Select(Job_Title);
objj.selectByValue("7");
Thread.sleep(3000);
WebElement Vacancy = driver.findElement(By.name("vacancySearch[jobVacancy]"));
Select obje=new Select(Vacancy);
obje.selectByVisibleText("Junior Software Engineer");
Thread.sleep(3000);
WebElement Hiring_Manager = driver.findElement(By.name("vacancySearch[hiringManager]"));
Select objec=new Select(Hiring_Manager);
objec.selectByValue("17");
Thread.sleep(3000);
WebElement Status = driver.findElement(By.name("vacancySearch[status]"));
Select object=new Select(Status);
object.selectByIndex(1);
Thread.sleep(3000);
driver.findElement(By.name("btnSrch")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//th/input")).click();





//Deleting Vacancy
driver.findElement(By.name("btnDelete")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
Thread.sleep(3000);
WebUtils.takeSnapshot(driver, "target/screenshots/test1.png");
driver.close();
}




}
@AfterMethod
public void tearDown() {
extent.flush(); // Instruct extent reports to write the test info to the destination
}
}