package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.RealizarPedidoException;
import com.lineadirecta.certificacion.interactions.CerrarPublicidad;
import com.lineadirecta.certificacion.models.RealizarCompraModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiAcordeon.*;
import static com.lineadirecta.certificacion.ui.UiInicioSesion.BTN_CERRAR_PUBLICIDAD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPedido implements Task {

    private final RealizarCompraModel realizarCompraModel;

    public RealizarPedido(RealizarCompraModel realizarCompraModel) {
        this.realizarCompraModel = realizarCompraModel;
    }

    public static RealizarPedido autenticadoEnLaApp(RealizarCompraModel realizarCompraModel){
        return Tasks.instrumented(RealizarPedido.class, realizarCompraModel);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(

                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),

                    WaitUntil.the(IMG_ACORDEON_DE_OPCIONES, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(IMG_ACORDEON_DE_OPCIONES),

                    WaitUntil.the(LBL_OPCION_DE_DESPLIEGUE.of(realizarCompraModel.getCategoria()), isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(LBL_OPCION_DE_DESPLIEGUE.of(realizarCompraModel.getCategoria())),

                    WaitUntil.the(LBL_OPCION_ARTICULO.of(realizarCompraModel.getOpcion()), isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(LBL_OPCION_ARTICULO.of(realizarCompraModel.getOpcion())),

                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),

                    WaitUntil.the(LBL_NOMBRE_PRODUCTO.of(realizarCompraModel.getPrenda()), isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(LBL_NOMBRE_PRODUCTO.of(realizarCompraModel.getPrenda()))
            );
        }catch (RuntimeException ex){
            throw new RealizarPedidoException(RealizarPedidoException.Error(), ex);
        }
    }
}
