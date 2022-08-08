package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user",config.username()); //"putintsevroman_3Pf26C");
        mutableCapabilities.setCapability("browserstack.key", config.password());  //"EKrqspnwbDjZCyJgpcYZ");
        mutableCapabilities.setCapability("app", "bs://"+ config.app());     //"bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("device",config.device());                //"Samsung Galaxy S22 Plus");
        mutableCapabilities.setCapability("os_version", config.os_version());    //"12.0");
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.URL());//"http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
