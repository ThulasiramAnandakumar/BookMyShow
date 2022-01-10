package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Properties;

public class Location
{
    @AndroidFindBy(id="com.bt.bms:id/btn_negative")
    public static WebElement enterLocationManually;

    @AndroidFindBy(xpath = "//*[@text=\"Chennai\"]")
    public static WebElement selectLocation;

    public Location(AndroidDriver<WebElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(Setup.driver),this);
    }


    public void chooselocation() throws IOException
    {
        Generic g=new Generic();
        Properties p=g.propertyFile();
        int time= Integer.parseInt((String) p.get("timeOut"));

        g.explicitWait(ExpectedConditions.visibilityOf(Location.enterLocationManually),time);
        enterLocationManually.click();

        g.explicitWait(ExpectedConditions.visibilityOf(Location.selectLocation),time);
        selectLocation.click();

    }
}
