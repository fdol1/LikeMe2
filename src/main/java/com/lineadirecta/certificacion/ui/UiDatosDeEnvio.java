package com.lineadirecta.certificacion.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UiDatosDeEnvio {

    public static final Target TXT_NOMBE =
            Target.the("Campo para ingresar nombre")
                    .locatedBy("(//div[@class = 'control']//input)[1]");

    public static final Target TXT_APELLIDO =
            Target.the("Campo para ingresar apellido")
                    .locatedBy("(//div[@class = 'control']//input)[2]");

    public static final Target CMBX_TIPO_DOCUMENTO =
            Target.the("Campo para seleccionar el tipo de cedula")
                    .locatedBy("(//div[@class = 'control']//select)[1]");

    public static final Target CMBX_TIPO_CEDULA_VALUE =
            Target.the("Campo para seleccionar el valor del tipo de cedula")
                    .locatedBy("(//div[@class = 'control']//select//option[contains(text(), '{0}')])[1]");

    public static final Target TXT_DOC_CLIENTE =
            Target.the("Campo para ingresar el documento del cliente")
                    .locatedBy("(//div[@class = 'control']//input)[3]");

    public static final Target TXT_CEDULAR =
            Target.the("Campo para ingresar el numero de celular")
                    .locatedBy("(//div[@class = 'control']//input)[4]");

    public static final Target TXT_DIRECCION_ENVIO =
            Target.the("Campo para ingresar la direccion de envio")
                    .locatedBy("(//div[@class = 'control']//input)[5]");

    public static final Target CMBX_DEPARTAMENTO =
            Target.the("Campo para seleccionar el departamento")
                    .locatedBy("(//div[@class = 'control']//select)[3]");

    public static final Target CMBX_DEPARTAMENTO_VALUE =
            Target.the("Campo para seleccionar el departamento")
                    .locatedBy("(//div[@class = 'control']//select//option[contains(text(), '{0}')])[1]");

    public static final Target CMBX_CIUDAD =
            Target.the("Campo para seleccionar el ciudad")
                    .locatedBy("(//div[@class = 'control']//select)[4]");

    public static final Target CMBX_CIUDAD_VALUE =
            Target.the("Campo para seleccionar el ciudad")
                    .locatedBy("(//div[@class = 'control']//select//option[contains(text(), '{0}')])[1]");

    public static final Target BTN_CONTINUAR =
            Target.the("Campo para seleccionar el ciudad")
                    .locatedBy("(//button[@class = 'button action continue primary'])[2]");


}




//
//Antioquia