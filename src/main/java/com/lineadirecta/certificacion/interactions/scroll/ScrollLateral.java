package com.lineadirecta.certificacion.interactions.scroll;

import com.lineadirecta.certificacion.interactions.ComandosCapabilities;
import com.lineadirecta.certificacion.utils.GetDriver;
import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ScrollLateral implements Interaction {
    private final String atributo;
    private final String selector;

    public ScrollLateral(String selector, String atributo) {
        this.selector = selector;
        this.atributo = atributo;
    }

    @Step("{0} scrolled to (#atributo)")
    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor)) {
            HashMap<String, String> scrollObject = new HashMap();
            scrollObject.put("predicateString", "value == '" + this.atributo + "'");
            scrollObject.put("direction", "right");
            GetDriver.as(actor).iosDriver().executeScript("mobile:scroll", new Object[]{scrollObject});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            GetDriver.as(actor).appiumDriver().findElement(MobileBy.AndroidUIAutomator(String.format(this.selector, this.atributo)));
        }
    }
}
