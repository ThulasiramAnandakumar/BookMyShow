package BookMyShow;

import POM.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class BookMy extends Setup
{
    AndroidDriver<WebElement> app;


    @Test(priority = 1)
    void homepage()
    {
        Login lp=new Login(Setup.driver);
        lp.setSkipLogin();
    }

    @Test(priority = 2)
    void locationSetup() throws IOException
    {
        Location lc=new Location(Setup.driver);
        lc.chooselocation();
    }

    @Test(priority = 3)
    void searchandselectMovie() throws IOException {
        Movie mv=new Movie(Setup.driver);
        mv.searchMovie();
    }

    @Test(priority = 4)
    void selectTiming() throws IOException
    {
        MovieTime mt=new MovieTime(Setup.driver);
        mt.timings();
    }
}
