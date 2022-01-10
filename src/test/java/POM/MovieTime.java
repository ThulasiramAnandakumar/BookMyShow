package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Properties;

public class MovieTime
{
    @AndroidFindBy(xpath = "(//*[@text=\"Velan\"])[2]")
    public static WebElement selectMovie;

    @AndroidFindBy(xpath = "//*[@text=\"Book tickets\"]")
    public static WebElement bookTickets;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView\n")
    public static WebElement skipPopUp;

    @AndroidFindBy(xpath = "(//*[@text=\"06:45 PM\"])[2]")
    public static WebElement selectTime;

    @AndroidFindBy(id = "com.bt.bms:id/primary_cta_venue_message_showtimes")
    public static  WebElement acceptTermsConditions;
    public MovieTime(AndroidDriver<WebElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(Setup.driver),this);

    }

    public  void timings() throws IOException
    {
        Generic g=new Generic();
        Properties p=g.propertyFile();

        int time= Integer.parseInt((String) p.get("timeOut"));


        g.explicitWait(ExpectedConditions.visibilityOf(MovieTime.selectMovie),time);
        selectMovie.click();
        g.explicitWait(ExpectedConditions.visibilityOf(MovieTime.bookTickets),time);
        bookTickets.click();

        g.explicitWait(ExpectedConditions.visibilityOf(MovieTime.skipPopUp),time);
        skipPopUp.click();

        g.explicitWait(ExpectedConditions.visibilityOf(MovieTime.selectTime),time);
        selectTime.click();

        g.explicitWait(ExpectedConditions.visibilityOf(MovieTime.acceptTermsConditions),time);
        acceptTermsConditions.click();
    }
}
