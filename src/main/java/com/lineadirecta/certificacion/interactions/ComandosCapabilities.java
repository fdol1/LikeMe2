package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;

public class ComandosCapabilities {

    private ComandosCapabilities() {
        throw new IllegalStateException("Error en ComandosCapabilities");
    }

    public static String getPlatformName(Actor actor) {
        return GetDriver.as(actor).appiumDriver().getCapabilities().getCapability("platformName").toString();
    }

    public static boolean isiOS(Actor actor) {
        return getPlatformName(actor).equals("iOS");
    }

    public static boolean isAndroid(Actor actor) {
        return getPlatformName(actor).equals("Android");
    }
}
