package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Properties;

public class Movie
{
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.ImageView\n")
    public static WebElement searchButton;

    @AndroidFindBy(xpath = "//*[@text=\"Search for movies, events & more...\"]")
    public static WebElement searchBox;



    public  Movie(AndroidDriver<WebElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(Setup.driver),this);

    }

    public void searchMovie() throws IOException {
        Generic g=new Generic();
        Properties p=g.propertyFile();

        String moviName= (String) p.get("MovieName");
        int time= Integer.parseInt((String) p.get("timeOut"));

        g.explicitWait(ExpectedConditions.visibilityOf(Movie.searchButton),time);
        searchButton.click();
        g.explicitWait(ExpectedConditions.visibilityOf(Movie.searchBox),time);
        searchBox.sendKeys(moviName);



    }

}
