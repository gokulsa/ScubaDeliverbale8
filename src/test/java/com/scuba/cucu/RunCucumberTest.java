package com.scuba.cucu;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\java\\com\\picnic\\featurefiles\\OrangeHrm.feature", 
                 glue= {"com/googlesearch/testing/steps/"},
                 monochrome = true,
                 plugin= {"pretty", "html:target/HtmlReports", "json:target/JSONReports/report.json", "junit:target/JUNITReports/report.xml"},
                 tags = "@sanitytest")
public class RunCucumberTest 
{
	
}