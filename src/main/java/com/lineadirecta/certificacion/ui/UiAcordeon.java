package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiAcordeon {

    public static final Target IMG_ACORDEON_DE_OPCIONES =
            Target.the("Elemento para desplegar opciones")
                    .locatedBy("//div[@class = 'header-middle-navigation desktop-hide']");

    public static final Target LBL_OPCION_DE_DESPLIEGUE =
            Target.the("Opciones del acorden desplegado")
                    .locatedBy("//span[@class = 'category-name'][contains(text(), '{0}')]");

    public static final Target LBL_OPCION_ARTICULO =
            Target.the("Elemento para seleccionar un articulo")
                    .locatedBy("(//span[@class = 'category-name'][contains(text(), '{0}')])[3]");

    public static final Target LBL_NOMBRE_PRODUCTO =
            Target.the("Elemento para seleccionar un articulo")
                    .locatedBy("(//h2[@class = 'h2-styles-for-items'][contains(text(), '{0}')])[1]");
}



