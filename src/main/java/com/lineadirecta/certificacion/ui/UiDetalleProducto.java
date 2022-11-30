package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiDetalleProducto {

    public static final Target IMG_TALLA =
            Target.the("Elemento talla de forma variable")
                    .locatedBy("(//div[@class = 'swatch-option text'][contains(text(), '{0}')])[1]");

    public static final Target BTN_AGREGAR_AL_CARRITO =
            Target.the("Boton para agregar al carrito")
                    .locatedBy("//div[@class = 'action-button']//button[@class = 'action primary tocart']");


}