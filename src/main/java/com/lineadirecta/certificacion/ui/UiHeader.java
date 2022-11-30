package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiHeader {

    public static final Target IMG_CARRITO_DE_COMPRAS =
            Target.the("Campo para ir a ver el carrito")
                    .locatedBy("//div[@class = 'minicart-wrapper']");

    public static final Target BTN_CERRAR_INFORMACION =
            Target.the("Opcion de cerrado para boton informativo")
                    .locatedBy("//a[@id='keep_products_true']");
}
