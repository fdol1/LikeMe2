package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiPerfilUsuario {

    public static final Target LBL_INFO_USUARIO =
            Target.the("Campo con el correo del usuario")
                    .locatedBy("((//div[@class='box box-information'])//span)[1]");
}