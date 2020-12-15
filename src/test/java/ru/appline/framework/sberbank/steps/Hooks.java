package ru.appline.framework.sberbank.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.sberbank.managers.DriverManager;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static ru.appline.framework.sberbank.managers.InitManager.initFramework;
import static ru.appline.framework.sberbank.managers.InitManager.quitFramework;

public class Hooks {

    @Before
    public static void doBeforeClass() {
        initFramework();
    }

    @After
    public static void doAfterClass(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("failureScreenshot", "image/png", addScreenshot(), "png");
        }
        quitFramework();
    }

    private static InputStream addScreenshot() {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(screenshot);
    }
}
