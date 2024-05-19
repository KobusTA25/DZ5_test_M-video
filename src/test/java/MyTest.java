import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class MyTest {
    @AndroidFindBy(id = "btnJoinConf")
    MobileElement btnJoinConf;

    @AndroidFindBy(id = "join_conf_title_view")
    MobileElement join_conf_title_view;

    @AndroidFindBy(id = "join_conf_btn_back")
    MobileElement join_conf_btn_back;

    @AndroidFindBy(id = "edtConfNumber")
    MobileElement edtConfNumber;

    @AndroidFindBy(id = "btnGotoVanityUrl")
    MobileElement btnGotoVanityUrl;

    @AndroidFindBy(id = "edtScreenName")
    MobileElement edtScreenName;

    private final DriverFactory driverFactory = new DriverFactory();
    private AndroidDriver<?> driver;

    @Before
    public void setDriver() throws MalformedURLException {

        driver = driverFactory.setUp();

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Test
    public void test() throws InterruptedException {
        btnJoinConf.click();

        Thread.sleep(2000);

        join_conf_title_view.isDisplayed();
        join_conf_btn_back.isDisplayed();
        edtConfNumber.isDisplayed();
        btnGotoVanityUrl.isDisplayed();
        edtScreenName.isDisplayed();

        MobileElement joinButton = (MobileElement) driver.findElementById("btnJoin");
        MobileElement linkText = (MobileElement) driver.findElementsByAndroidUIAutomator("textContains(\"tap on the link to join the meeting\")");
        MobileElement optionsTitle = (MobileElement) driver.findElementsByAndroidUIAutomator("textContains(\"JOIN OPTIONS\")");
        MobileElement optionNoAudio = (MobileElement) driver.findElementsByAndroidUIAutomator("textContains(\"Don't Connect To Audio\")");
        MobileElement chkNoAudio = (MobileElement) driver.findElementById("chkNoAudio");

        joinButton.isDisplayed();
        linkText.isDisplayed();
        optionsTitle.isDisplayed();
        optionNoAudio.isDisplayed();
        chkNoAudio.isDisplayed();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

