package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebElement;

public class EncuentraElElemento {

    Actor actor;

    private EncuentraElElemento() {
        throw new IllegalStateException("Error en EncuentraElElemento");
    }

    public EncuentraElElemento(Actor actor) {
        this.actor = actor;
    }

    public static EncuentraElElemento as(Actor actor) {
        return new EncuentraElElemento(actor);
    }

    public WebElement conTextoEnAndroid(String selector, String atributo) {
        return GetDriver.as(this.actor).androidDriver().findElementByAndroidUIAutomator(String.format(selector, atributo));
    }

    public WebElement conTextoEniOS(String atributo) {
        return GetDriver.as(this.actor).iosDriver().findElementByIosNsPredicate("type == 'XCUIElementTypeStaticText' && " + String.format("value CONTAINS '%s'", atributo));
    }
}
