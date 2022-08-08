package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.RealMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;


public class TestBase {
    static String Host;
    @BeforeAll
    public static void setup() {

        Host =  System.getProperty("deviceHost", "local");

        switch (Host){
            case ("browserstack"):
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case ("real"):
                Configuration.browser = RealMobileDriver.class.getName();
                break;
            case ("emulation"):
            default:
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

       if(Host.equals("browserstack")) Attach.video(sessionId);
    }
}
