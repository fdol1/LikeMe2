package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiResumenCompra {

    public static final Target LBL_TOTAL_COMPRA =
            Target.the("Elemento que contiene el precio de la compra")
                    .locatedBy("(//strong//span)[8]");

    public static final Target BTN_INICIAR_PAGO =
            Target.the("Boton para iniciar el pago")
                    .locatedBy("(//button[@class = 'action primary checkout'])[2]");
}