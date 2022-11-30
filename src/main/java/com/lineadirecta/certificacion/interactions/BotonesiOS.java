package com.lineadirecta.certificacion.interactions;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class BotonesiOS {
    public static final Target BTN_ACEPTAR = Target.the("boton aceptar teclado").located(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name CONTAINS 'Aceptar' OR name CONTAINS 'Done' OR label CONTAINS 'intro' OR label CONTAINS 'return'"));
    public static final Target BTN_LISTO = Target.the("boton listo teclado").located(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name CONTAINS 'Listo'"));

    private BotonesiOS() {
        throw new IllegalStateException("error en botones iOS");
    }
}