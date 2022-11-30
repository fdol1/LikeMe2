package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiRevisarYConfirmar {

    public static final Target CMBX_OPCION_ENVIO_FACTURA =
            Target.the("Seleccionar la opcion para recibir la factura")
                    .locatedBy("//select[@class = 'select-how-receive-invoice']");

    public static final Target CMBX_OPCION_ENVIO_FACTURA_VALUE =
            Target.the("Seleccionar la opcion para recibir la factura")
                    .locatedBy("//select[@class = 'select-how-receive-invoice']//option[contains(text(),'{0}')]");

    public static final Target CHBX_METODO_PAGO =
            Target.the("Elemento para pasar el metodo de pago")
                    .locatedBy("//div[@class= 'payment-method-title field choice']//span[contains(text(), '{0}')]");

    public static final Target BTN_FINALIZAR_COMPRA =
            Target.the("Boton para finalizar la compra")
                    .locatedBy("//button[@class= 'action primary checkout']");

}

//Contra Entrega en Efectivo
//Tarjeta de Crédito
//Débito - PSE / Nequi / Davi Plata /


