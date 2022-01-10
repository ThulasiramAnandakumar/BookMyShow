package POM;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Generic extends  Setup
{
    public void explicitWait(Function element, int time )
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(element);
    }
    public  void implicitWait(int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public  void scrollDown(String text)
    {
        driver.findElementByAndroidUIAutomator
                        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text
                                + "\").instance(0))")
                .click();
    }

    public Properties propertyFile() throws IOException
    {
        Properties pf=new Properties();
        FileInputStream fp=new FileInputStream("/home/qq383/eclipse-workspace/Dummy/src/test/java/Data/data.properties");
        pf.load(fp);
        return pf;
    }
}
