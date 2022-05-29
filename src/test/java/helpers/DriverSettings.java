package helpers;

import com.codeborne.selenide.Configuration;
import config.Project;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.timeout = Project.config.timeout();

        if (Project.isRemoteWebDriver()) {
            Configuration.remote = Project.config.remoteDriverUrl();
        }
    }
}
