package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.AgregarAlCarritoException;
import com.lineadirecta.certificacion.interactions.*;
import com.lineadirecta.certificacion.models.RealizarCompraModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiCarrito.BTN_IR_AL_CARRITO;
import static com.lineadirecta.certificacion.ui.UiCarrito.BTN_MAS;
import static com.lineadirecta.certificacion.ui.UiDetalleProducto.*;

public class AgregarAlCarrito implements Task {

    private final RealizarCompraModel realizarCompraModel;

    public AgregarAlCarrito(RealizarCompraModel realizarCompraModel) {
        this.realizarCompraModel = realizarCompraModel;
    }

    public static AgregarAlCarrito elProductoEnPantalla(RealizarCompraModel realizarCompraModel) {
        return Tasks.instrumented(AgregarAlCarrito.class, realizarCompraModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    FalsaEspera.enPantalla(2000),
                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),
                    SwipeByCoordinates.onScreem(305, 1067, 327, 383),
                    SwipeByCoordinates.onScreem(360, 1165, 364, 750),

                    SeleccionarTalla.paraLaPrendaAComprar(IMG_TALLA.of(realizarCompraModel.getTalla())),
                    TapByCoordinates.onScreen(33,1155),
                    //WaitUntil.the(BTN_AGREGAR_AL_CARRITO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    //Click.on(BTN_AGREGAR_AL_CARRITO),
                    WaitUntil.the(BTN_MAS, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    AgregarCantidad.delProductoSeleccionado(realizarCompraModel.getCantidad()),
                    FalsaEspera.enPantalla(4000),
                    Click.on(BTN_IR_AL_CARRITO)

            );
        } catch (RuntimeException ex) {
            throw new AgregarAlCarritoException(AgregarAlCarritoException.Error(), ex);
        }
    }
}