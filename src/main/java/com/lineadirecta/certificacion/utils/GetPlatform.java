package com.lineadirecta.certificacion.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetPlatform extends MobilePageObject {

    public GetPlatform(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
    @SuppressWarnings("unchecked")
    AppiumDriver<MobileElement> conexionAppium = ((AppiumDriver<MobileElement>) ((WebDriverFacade) getDriver())
            .getProxiedDriver());

    public AppiumDriver<MobileElement> getconexionAppium() {
        return this.conexionAppium;
    }
}