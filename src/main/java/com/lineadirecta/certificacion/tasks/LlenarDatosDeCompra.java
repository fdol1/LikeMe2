package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.interactions.Hide;
import com.lineadirecta.certificacion.interactions.SwipeByCoordinates;
import com.lineadirecta.certificacion.models.DatosCompraModel;
import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static com.lineadirecta.certificacion.ui.UiDatosDeEnvio.*;

public class LlenarDatosDeCompra implements Task {

    private final DatosCompraModel datosCompraModel;

    public LlenarDatosDeCompra(DatosCompraModel datosCompraModel) {
        this.datosCompraModel = datosCompraModel;
    }

    public static LlenarDatosDeCompra paraPagar(DatosCompraModel datosCompraModel) {
        return Tasks.instrumented(LlenarDatosDeCompra.class, datosCompraModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBE, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Enter.theValue(datosCompraModel.getNombre()).into(TXT_NOMBE),

                WaitUntil.the(TXT_APELLIDO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Enter.theValue(datosCompraModel.getApellido()).into(TXT_APELLIDO),

                WaitUntil.the(CMBX_TIPO_DOCUMENTO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Click.on(CMBX_TIPO_DOCUMENTO),

                WaitUntil.the(CMBX_TIPO_CEDULA_VALUE.of(datosCompraModel.getTipoDoc()), WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Click.on(CMBX_TIPO_CEDULA_VALUE.of(datosCompraModel.getTipoDoc())),

                Hide.Keyboard(),

                SwipeByCoordinates.onScreem(499,508,526,443),

                WaitUntil.the(TXT_DOC_CLIENTE, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Enter.theValue(datosCompraModel.getNumDoc()).into(TXT_DOC_CLIENTE),

                WaitUntil.the(TXT_CEDULAR, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Enter.theValue(datosCompraModel.getNumDoc()).into(TXT_CEDULAR),

                WaitUntil.the(TXT_DIRECCION_ENVIO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                Enter.theValue(datosCompraModel.getNumDoc()).into(TXT_DIRECCION_ENVIO)

                //WaitUntil.the(CMBX_DEPARTAMENTO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                //Click.on(CMBX_DEPARTAMENTO),
//
                //WaitUntil.the(CMBX_DEPARTAMENTO_VALUE, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                //Click.on(CMBX_DEPARTAMENTO_VALUE),
//
//
                //WaitUntil.the(CMBX_CIUDAD, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                //Click.on(CMBX_CIUDAD),
//
                //WaitUntil.the(CMBX_CIUDAD_VALUE, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                //Click.on(CMBX_CIUDAD_VALUE),
//
                //Click.on(BTN_CONTINUAR)

        );
    }
}
