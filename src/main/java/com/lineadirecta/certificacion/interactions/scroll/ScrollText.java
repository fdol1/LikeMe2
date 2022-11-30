package com.lineadirecta.certificacion.interactions.scroll;

import com.lineadirecta.certificacion.interactions.ComandosCapabilities;
import com.lineadirecta.certificacion.interactions.EncuentraElElemento;
import com.lineadirecta.certificacion.utils.GetDriver;
import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ScrollText implements Interaction {
    private final String atributo;
    private final String selector;

    public ScrollText(String selector, String atributo) {
        this.selector = selector;
        this.atributo = atributo;
    }

    @Step("{0} scrolled to (#atributo)")
    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor) && !EncuentraElElemento.as(actor).conTextoEniOS(this.atributo).isDisplayed()) {
            HashMap<String, String> scrollObject = new HashMap();
            scrollObject.put("predicateString", "value == '" + this.atributo + "'");
            scrollObject.put("direction", "down");
            GetDriver.as(actor).iosDriver().executeScript("mobile:swipe", new Object[]{scrollObject});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            GetDriver.as(actor).appiumDriver().findElement(MobileBy.AndroidUIAutomator(String.format(this.selector, this.atributo)));
        }
    }
}