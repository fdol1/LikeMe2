package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiInicioSesion {

    public static final Target BTN_ACEPTAR_USO_DE_COOKIES =
            Target.the("Boton para aceptar uso de cookies ")
                    .locatedBy("//span[contains(text(), 'Aceptar')]");

    public static final Target BTN_CERRAR_PUBLICIDAD =
            Target.the("Boton para cerrar publicidad")
                    .locatedBy("//div[@class='icon']");

    public static final Target TXT_USUARIO =
            Target.the("Campo para ingresar el usuario")
                    .locatedBy("//input[@id='email']");

    public static final Target TXT_CLAVE =
            Target.the("Campo para ingresar la clave")
                    .locatedBy("//div[@class = 'control password-view password-view-initialized']//input");

    public static final Target BTN_INICIAR_SESION =
            Target.the("Boton para iniciar la sesion del usuario")
                    .locatedBy("(//div[@class = 'primary']//button)[1]");


    public static final Target LBL_MENSAJE_FORMATO_ARRADO =
            Target.the("Se presenta un mensaje referente al error del formato de correo")
                    .locatedBy("//div[@class='control']//div");

    public static final Target LBL_CLAVE_INVALIDA =
            Target.the("")
                    .locatedBy("(//fieldset[@class = 'fieldset login']//div)[9]");
}