import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {
    AppiumDriver driver; // Use generics with AppiumDriver

    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2"); // Corrected case
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("app",  "C:/Users/Murad Misu/IdeaProjects/Mobile_app_learning_1/testapk/sample Calculator-v1.0-ChipApk.apk"); // apk link
//        caps.setCapability("autoGrantPermissions", true);
//        caps.setCapability("autoAcceptAlerts", true);
//

        // Use the AndroidDriver constructor with generics
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723"), caps); // Updated URL


    }
    @Step
    @Test()
    public void clickOnApp() throws InterruptedException {

        // calculator element
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.bak.mnr.calculatrice:id/btn2\"]")).click();
    //
    Thread.sleep(5000);

    }
    @AfterTest
    public void tear_down(){
        if(null !=driver){
            driver.quit();
        }

    }
}
