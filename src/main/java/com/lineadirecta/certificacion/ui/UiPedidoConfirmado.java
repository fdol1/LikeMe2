package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiPedidoConfirmado {

    public static final Target LBL_PEDIDO_CONFIRMADO =
            Target.the("Campo con el mensaje de compra realizada con exito")
                    .locatedBy("//div[@class= 'checkout-success-content']//h3");

}
