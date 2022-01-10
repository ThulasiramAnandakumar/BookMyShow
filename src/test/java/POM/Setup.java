package POM;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Setup
{
    public static AndroidDriver<WebElement> driver;

    @BeforeTest(alwaysRun = true)
    public static void setCapabilities()
    {
        DesiredCapabilities dc=new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("automation_Name", "UiAutomator2");
        dc.setCapability("appActivity", "com.movie.bms.splashscreen.SplashScreenActivity");
        dc.setCapability("appPackage", "com.bt.bms");


        driver=new AndroidDriver<>(dc);
    }
}
