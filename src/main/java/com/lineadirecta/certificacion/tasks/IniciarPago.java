package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.IniciarPagoException;
import com.lineadirecta.certificacion.interactions.CerrarPublicidad;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import com.lineadirecta.certificacion.interactions.SwipeByCoordinates;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiCarrito.BTN_IR_AL_CARRITO;
import static com.lineadirecta.certificacion.ui.UiHeader.BTN_CERRAR_INFORMACION;
import static com.lineadirecta.certificacion.ui.UiHeader.IMG_CARRITO_DE_COMPRAS;
import static com.lineadirecta.certificacion.ui.UiInicioSesion.*;
import static com.lineadirecta.certificacion.ui.UiResumenCompra.BTN_INICIAR_PAGO;

public class IniciarPago implements Task {

    public IniciarPago() {
    }

    public static IniciarPago deLosProductos() {
        return Tasks.instrumented(IniciarPago.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    //CerrarPublicidad.enLaPantalla(BTN_ACEPTAR_USO_DE_COOKIES),
                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),
                    CerrarPublicidad.enLaPantalla(BTN_CERRAR_INFORMACION),

                    WaitUntil.the(IMG_CARRITO_DE_COMPRAS, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(IMG_CARRITO_DE_COMPRAS),

                    WaitUntil.the(BTN_IR_AL_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_IR_AL_CARRITO),

                    SwipeByCoordinates.onScreem(305,1067,327,383),

                    WaitUntil.the(BTN_INICIAR_PAGO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_INICIAR_PAGO),

                    FalsaEspera.enPantalla(5000)

                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_INFORMACION)
            );
        }catch (RuntimeException ex){
            throw new IniciarPagoException(IniciarPagoException.Error(),ex);
        }
    }
}
