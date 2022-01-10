package POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login
{
    @AndroidFindBy(id="com.bt.bms:id/launcher_tv_for_skip")
    public WebElement skipLogin;

    public Login(AndroidDriver<WebElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    public void setSkipLogin()
    {
        skipLogin.click();
    }


}
