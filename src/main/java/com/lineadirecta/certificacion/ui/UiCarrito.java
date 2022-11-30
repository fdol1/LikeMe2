package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiCarrito {

    public static final Target BTN_MAS =
            Target.the("Boton para aumentar la cantidad del producto")
                    .locatedBy("//span[contains(text(),'+')]");

    public static final Target BTN_IR_AL_CARRITO =
            Target.the("Boton para ir al carrito")
                    .locatedBy("(//div[@class = 'secondary'])[2]");
}