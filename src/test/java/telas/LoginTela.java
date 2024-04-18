package paginas;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver app;

    public LoginPage(WebDriver app){
        this.app = new AndroidDriver(app);
    }


}
